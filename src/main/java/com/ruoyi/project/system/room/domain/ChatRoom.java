package com.ruoyi.project.system.room.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 微信群管理对象 chat_room
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public class ChatRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 微信群名字 */
    @Excel(name = "微信群名字")
    private String themeName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** $table.subTable.functionName信息 */
    private List<ChatRoomUserRele> chatRoomUserReleList;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setThemeName(String themeName)
    {
        this.themeName = themeName;
    }

    public String getThemeName()
    {
        return themeName;
    }
    public void setCreationTime(Date creationTime)
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime()
    {
        return creationTime;
    }
    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }

    public List<ChatRoomUserRele> getChatRoomUserReleList()
    {
        return chatRoomUserReleList;
    }

    public void setChatRoomUserReleList(List<ChatRoomUserRele> chatRoomUserReleList)
    {
        this.chatRoomUserReleList = chatRoomUserReleList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("themeName", getThemeName())
            .append("creationTime", getCreationTime())
            .append("modifyTime", getModifyTime())
            .append("chatRoomUserReleList", getChatRoomUserReleList())
            .toString();
    }
}
