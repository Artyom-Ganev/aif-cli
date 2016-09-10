package com.aif.language.sentence;

import java.util.function.Function;

public interface ICommand extends Function<String[], Void> {

  boolean validate(final String... args);

  enum Commands {

    SENTENCE_SPLIT("ssplit", new SentenceSplitCommand(), "Split text to sentences"),

    SENTENCE_SEPARATOR_EXTRACTOR("ess", new SentencesSeparatorExtractorCommand(),
        "Extract sentences separators"),
    DICT_BUILD("dbuild", new DictBuildCommand(), "Build text dictionary from source text"),

    TOKEN_SPLIT("tsplit", new TokenSplitCommand(), "Split text to tokens"),

    TOKEN_SEPARATOR_EXTRACTOR("ets", new TokenSeparatorExtractorCommand(),
        "Get token separator unicode hex"),

    SEMANTIC_DICT_BUILD("sbuild", new SemanticDictBuildCommand(),
        "Build Semantic Dictionary and save result in the file"),

    HELP("help", new PrintHelpCommand(), "Print this message"),

    VERSION("v", new PrintVersionCommand(), "Print CLI and AIF versions");


    private final String commandKey;

    private final ICommand command;

    private final String helpLine;

    Commands(final String commandKey, final ICommand command, final String helpLine) {
      this.commandKey = commandKey;
      this.command = command;
      this.helpLine = helpLine;
    }

    public String getCommandKey() {
      return commandKey;
    }

    public ICommand getCommand() {
      return command;
    }

    public String getHelpLine() {
      return helpLine;
    }

  }

}
