package com.ruoyi.chanpin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品管理对象 tb_chanpin
 * 
 * @author ruoyi
 * @date 2024-06-21
 */
public class Chanpin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品id */
    private Long id;

    /** 型号 */
    @Excel(name = "型号")
    private String code;

    /** 产品品类 */
    @Excel(name = "产品品类")
    private String pinlei;

    /** 车型类型 */
    @Excel(name = "车型类型")
    private String chexing;

    /** 装运类型 */
    @Excel(name = "装运类型")
    private String zhuangyun;

    /** 电池类型（标配500瓦电机） */
    @Excel(name = "电池类型", readConverterExp = "标=配500瓦电机")
    private String batteryType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setPinlei(String pinlei) 
    {
        this.pinlei = pinlei;
    }

    public String getPinlei() 
    {
        return pinlei;
    }
    public void setChexing(String chexing) 
    {
        this.chexing = chexing;
    }

    public String getChexing() 
    {
        return chexing;
    }
    public void setZhuangyun(String zhuangyun) 
    {
        this.zhuangyun = zhuangyun;
    }

    public String getZhuangyun() 
    {
        return zhuangyun;
    }
    public void setBatteryType(String batteryType) 
    {
        this.batteryType = batteryType;
    }

    public String getBatteryType() 
    {
        return batteryType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("pinlei", getPinlei())
            .append("chexing", getChexing())
            .append("zhuangyun", getZhuangyun())
            .append("batteryType", getBatteryType())
            .toString();
    }
}
