package com.ruoyi.project.system.room.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * ${subTable.functionName}对象 chat_room_user_rele
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public class ChatRoomUserRele extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间号id */
    @Excel(name = "房间号id")
    private Long chatRoomId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long chatUserId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creationTime;

    public void setChatRoomId(Long chatRoomId) 
    {
        this.chatRoomId = chatRoomId;
    }

    public Long getChatRoomId() 
    {
        return chatRoomId;
    }
    public void setChatUserId(Long chatUserId) 
    {
        this.chatUserId = chatUserId;
    }

    public Long getChatUserId() 
    {
        return chatUserId;
    }
    public void setCreationTime(Date creationTime) 
    {
        this.creationTime = creationTime;
    }

    public Date getCreationTime() 
    {
        return creationTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("chatRoomId", getChatRoomId())
            .append("chatUserId", getChatUserId())
            .append("creationTime", getCreationTime())
            .toString();
    }
}
