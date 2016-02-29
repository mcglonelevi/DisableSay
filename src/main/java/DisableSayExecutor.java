import org.spongepowered.api.Server;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.command.TabCompleteEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

/**
 * Created by Levi on 2/29/2016.
 */
public class DisableSayExecutor implements CommandExecutor {

    private Server server;

    public DisableSayExecutor (Server server) {
        this.server = server;
    }

    @Override
    public CommandResult execute(CommandSource commandSource, CommandContext commandContext) throws CommandException {
        if (commandSource instanceof Player) {
            Text text = Text.builder("[Server] " + commandContext.<String>getOne("message").get()).color(TextColors.RED).build();
            server.getBroadcastChannel().send(commandSource, text);
        } else {
            commandSource.sendMessage(Text.of("This command has been disabled for console."));
        }
        return CommandResult.success();
    }
}
