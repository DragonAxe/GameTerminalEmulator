package org.storytotell.game.termemu;

/**
 * A command inside the terminal emulator.
 */
public interface Command {
  /**
   * @return the name of the executable
   */
  String getName();

  /**
   * Executes this command in the supplied context.
   * @param ctx  the execution context (standard input, etc.)
   * @return     the result code (0 for success, anything else is an error code)
   */
  int execute(Context ctx, String[] arguments);
}
