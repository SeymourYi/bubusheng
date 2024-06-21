package com.ruoyi.chanpin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.chanpin.domain.Chanpin;
import com.ruoyi.chanpin.service.IChanpinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
@RestController
@RequestMapping("/chanpin/chanpin")
public class ChanpinController extends BaseController
{
    @Autowired
    private IChanpinService chanpinService;

    /**
     * 查询产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:list')")
    @GetMapping("/list")
    public TableDataInfo list(Chanpin chanpin)
    {
        startPage();
        List<Chanpin> list = chanpinService.selectChanpinList(chanpin);
        return getDataTable(list);
    }

    /**
     * 导出产品管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:export')")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Chanpin chanpin)
    {
        List<Chanpin> list = chanpinService.selectChanpinList(chanpin);
        ExcelUtil<Chanpin> util = new ExcelUtil<Chanpin>(Chanpin.class);
        util.exportExcel(response, list, "产品管理数据");
    }

    /**
     * 获取产品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(chanpinService.selectChanpinById(id));
    }

    /**
     * 新增产品管理
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:add')")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Chanpin chanpin)
    {
        return toAjax(chanpinService.insertChanpin(chanpin));
    }

    /**
     * 修改产品管理
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:edit')")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Chanpin chanpin)
    {
        return toAjax(chanpinService.updateChanpin(chanpin));
    }

    /**
     * 删除产品管理
     */
    @PreAuthorize("@ss.hasPermi('chanpin:chanpin:remove')")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(chanpinService.deleteChanpinByIds(ids));
    }
}
