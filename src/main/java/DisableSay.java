import com.google.inject.Inject;
import org.spongepowered.api.Game;
import org.spongepowered.api.Server;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "disablesay", name = "Disable Say", version = "1.0")
public class DisableSay {
    @Inject
    Game game;

    @Listener
    public void onInit(GameInitializationEvent event) {
        Server server = game.getServer();
        CommandSpec disableSaySpec = CommandSpec.builder()
                .description(Text.of("Disables Say Command in Console"))
                .permission("disablesay.say")
                .arguments(GenericArguments.remainingJoinedStrings(Text.of("message")))
                .executor(new DisableSayExecutor(server))
                .build();
        game.getCommandManager().register(this, disableSaySpec, "say");
    }
}
