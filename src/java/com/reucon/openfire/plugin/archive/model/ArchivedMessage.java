package com.reucon.openfire.plugin.archive.model;

import org.jivesoftware.database.JiveID;
import org.xmpp.packet.JID;

import java.util.Date;
import java.util.UUID;

/**
 * An archived message.
 */
@JiveID(601)
public class ArchivedMessage {
    public enum Direction {
        /**
         * A message sent by the owner.
         */
        to,

        /**
         * A message received by the owner.
         */
        from
    }

    private Long id;
    private final Date time;
    private final Direction direction;
    private final String type;
    private String subject;
    private String body;
    private Conversation conversation;
    private JID with;
    private String stanza;
    private UUID stableId;

    public ArchivedMessage( Date time, Direction direction, String type, JID with, UUID stableId) {
        this.time = time;
        this.direction = direction;
        this.type = type;
        this.with = with;
        this.stableId = stableId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getType() {
        return type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    /**
     * Checks if this message contains payload that should be archived.
     *
     * @return <code>true</code> if this message is empty, <code>false</code>
     *         otherwise.
     */
    public boolean isEmpty() {
        return subject == null && body == null;
    }

    public JID getWith() {
        return with;
    }

    public UUID getStableId()
    {
        return stableId;
    }

    public void setStableId( final UUID stableId )
    {
        this.stableId = stableId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ArchivedMessage[id=").append(id).append(",");
        sb.append("stableId=").append(stableId).append(",");
        sb.append("time=").append(time).append(",");
        sb.append("direction=").append(direction).append("]");

        return sb.toString();
    }
}
