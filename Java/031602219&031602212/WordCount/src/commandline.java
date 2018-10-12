import org.apache.commons.cli.Options;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.CommandLine;


@SuppressWarnings("deprecation")
public class commandline {	
	
	public String infile = new String();
	public String outfile = new String();
	public String weight = new String();
	public String member = new String("1");
	public String number = new String("10");
	
	public commandline(String[] args) {
		
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		
		options.addOption("h", "help", false,"Helps About this Command");
		options.addOption("i", "input", true, "Input this file");
		options.addOption("o", "output", true, "Output this file");
		options.addOption("w", "weight", true, "Weight of the word");
		options.addOption("m", "members", true, "Members of count words");
		options.addOption("n", "number", true, "Numbers of output words");
		
		try {
			CommandLine commandline = parser.parse(options, args);
			if (commandline.getOptions().length > 0) {
				if(commandline.hasOption("h")) {
					HelpFormatter formatter = new HelpFormatter();
					formatter.printHelp("CommandLineParameters",options);
				}
				if(commandline.hasOption("i")) {
					infile =  commandline.getOptionValue("i");
				}
				if(commandline.hasOption("o")) {
					outfile =  commandline.getOptionValue("o");
				}
				if(commandline.hasOption("w")) {
					weight =  commandline.getOptionValue("w");
				}
				if(commandline.hasOption("m")) {
					member =  commandline.getOptionValue("m");
					if(Integer.parseInt(member)<2 | Integer.parseInt(member)>10) {
						System.err.println("ERROR_MESSAGE:THE PHRASE LENGTH OUT OF BOUNDS (2<=m<=10)");
						System.exit(1);
					}
				}
				if(commandline.hasOption("n")) {
					number =  commandline.getOptionValue("n");
					if(Integer.parseInt(number)>100|Integer.parseInt(number)<0) {
						System.err.println("ERROR_MESSAGE:THE OUTPUT PHRASE LENGTH OUT OF BOUNDS (0<=n<=100)");
						System.exit(1);
					}
				}
			}
			else {
				System.err.println("ERROR_MESSAGE:NO ARGS");
				System.exit(1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
