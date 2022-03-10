package ppp.stats.models;

import org.w3c.dom.Text;

import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.PrivateChannel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.object.entity.channel.Channel.Type;

public interface DiscordTextChannel extends ITextChannel {
    public static DiscordTextChannel from(Channel channel) {
        switch (channel.getType()) {
            case DM:
            case GROUP_DM:
                return new DiscordDMChannel((PrivateChannel)channel);
            case GUILD_TEXT:
                return new DiscordGuildChannel((TextChannel)channel);
            case UNKNOWN:
            default:
                return null;
        }
    }
}
