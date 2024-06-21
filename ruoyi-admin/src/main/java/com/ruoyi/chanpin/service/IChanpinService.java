package com.ruoyi.chanpin.service;

import java.util.List;
import com.ruoyi.chanpin.domain.Chanpin;

/**
 * 产品管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
public interface IChanpinService 
{
    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    public Chanpin selectChanpinById(Long id);

    /**
     * 查询产品管理列表
     * 
     * @param chanpin 产品管理
     * @return 产品管理集合
     */
    public List<Chanpin> selectChanpinList(Chanpin chanpin);

    /**
     * 新增产品管理
     * 
     * @param chanpin 产品管理
     * @return 结果
     */
    public int insertChanpin(Chanpin chanpin);

    /**
     * 修改产品管理
     * 
     * @param chanpin 产品管理
     * @return 结果
     */
    public int updateChanpin(Chanpin chanpin);

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的产品管理主键集合
     * @return 结果
     */
    public int deleteChanpinByIds(Long[] ids);

    /**
     * 删除产品管理信息
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    public int deleteChanpinById(Long id);
}
