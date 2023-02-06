package ru.nsu.fit.oop.task1;

import org.apache.commons.cli.*;

public class ClParser
{
    private CommandLine commandLine;

    public boolean parse(String[] args)
            throws ParseException
    {
        Options opts = new Options();
        opts.addOption(Option.builder()
                             .option("h")
                             .longOpt("help")
                             .desc("Print command help")
                             .build());

        CommandLineParser clParser = new DefaultParser();
        commandLine = clParser.parse(opts,
                                     args,
                                     true);

        opts.addOption(Option.builder()
                             .option("i")
                             .longOpt("input")
                             .desc("Input file")
                             .hasArg()
                             .argName("path")
                             .numberOfArgs(1)
                             .type(String.class)
                             .required()
                             .build())
            .addOption(Option.builder()
                             .option("o")
                             .longOpt("output")
                             .desc("Output csv file")
                             .hasArg()
                             .argName("path")
                             .numberOfArgs(1)
                             .type(String.class)
                             .required()
                             .build());

        if (args.length == 0 ||
            commandLine.hasOption("help"))
        {
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("app",
                                    opts,
                                    true);
            return false;
        }

        commandLine = clParser.parse(opts,
                                     args);
        return true;
    }

    public Object getInput()
            throws ParseException
    {
        return commandLine.getParsedOptionValue("input");
    }

    public Object getOutput()
            throws ParseException
    {
        return commandLine.getParsedOptionValue("output");
    }
}
