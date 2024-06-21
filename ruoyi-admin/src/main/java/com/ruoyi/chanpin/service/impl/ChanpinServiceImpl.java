package com.ruoyi.chanpin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanpin.mapper.ChanpinMapper;
import com.ruoyi.chanpin.domain.Chanpin;
import com.ruoyi.chanpin.service.IChanpinService;

/**
 * 产品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
@Service
public class ChanpinServiceImpl implements IChanpinService 
{
    @Autowired
    private ChanpinMapper chanpinMapper;

    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    @Override
    public Chanpin selectChanpinById(Long id)
    {
        return chanpinMapper.selectChanpinById(id);
    }

    /**
     * 查询产品管理列表
     * 
     * @param chanpin 产品管理
     * @return 产品管理
     */
    @Override
    public List<Chanpin> selectChanpinList(Chanpin chanpin)
    {
        return chanpinMapper.selectChanpinList(chanpin);
    }

    /**
     * 新增产品管理
     * 
     * @param chanpin 产品管理
     * @return 结果
     */
    @Override
    public int insertChanpin(Chanpin chanpin)
    {
        return chanpinMapper.insertChanpin(chanpin);
    }

    /**
     * 修改产品管理
     * 
     * @param chanpin 产品管理
     * @return 结果
     */
    @Override
    public int updateChanpin(Chanpin chanpin)
    {
        return chanpinMapper.updateChanpin(chanpin);
    }

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的产品管理主键
     * @return 结果
     */
    @Override
    public int deleteChanpinByIds(Long[] ids)
    {
        return chanpinMapper.deleteChanpinByIds(ids);
    }

    /**
     * 删除产品管理信息
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    @Override
    public int deleteChanpinById(Long id)
    {
        return chanpinMapper.deleteChanpinById(id);
    }
}
