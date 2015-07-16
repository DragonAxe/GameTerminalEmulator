package org.storytotell.game.termemu;

import org.storytotell.game.termemu.standard.Cat;
import org.storytotell.game.termemu.standard.Echo;
import org.storytotell.game.termemu.standard.Ls;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A fake shell for the game.
 */
public class Shell {
  private Context ctx;
  private CommandMap commandMap;
  private boolean finished;

  private Shell() {
    initialize();
  }

  public Shell(Context ctx) {
    this();
    this.ctx = ctx;
  }

  /**
   * Initialize the shell.
   */
  private void initialize() {
    // initialize the command map
    commandMap = new CommandMap();

    // add the standard commands
    commandMap.addCommand(new Cat());
    commandMap.addCommand(new Echo());
    commandMap.addCommand(new Ls());
    commandMap.addCommand(new Exit());
  }

  /**
   * Launch the shell process
   */
  public void launch() {
    finished = false;

    // REPL = read eval print loop (and this is why)
    while (!finished)
      print(eval(read()));
  }

  /**
   * The print part of the REPL. Currently no-op, should print a prompt
   * or something.
   */
  private void print(int execute) {
  }

  /**
   * The eval part of the REPL. Executes the command.
   * @param commandLine
   * @return
   */
  private int eval(String[] commandLine) {
    // look up the command and execute it
    return commandMap.execute(ctx, commandLine);
  }

  private String[] read() {
    return null;
  }

  // Shell builtin: exit
  private class Exit implements Command {
    @Override
    public String getName() {
      return "exit";
    }

    /**
     * Exit the shell.
     */
    @Override
    public int execute(Context ctx, String[] arguments) {
      finished = true;
      return 0;
    }
  }

  private static class CommandMap extends HashMap<String, Command> {
    /**
     * Add a command to the command map.
     * @param cmd a command
     */
    public void addCommand(Command cmd) {
      put(cmd.getName(), cmd);
    }

    /**
     * Execute the given command line using the supplied context, by looking up
     * the command line's executable in ourselves.
     *
     * @param ctx
     * @param commandLine
     * @return
     */
    public int execute(Context ctx, String[] commandLine) {
      if (commandLine.length > 0) {
        String[] args = Arrays.copyOfRange(commandLine, 1, commandLine.length - 1);
        return get(commandLine[0]).execute(ctx, args);
      }
      else
        return -1;
    }
  }
}
