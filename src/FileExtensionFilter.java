import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Class ensured files are of the correct extensions.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 * Reference: https://www.codejava.net/java-se/swing/add-file-filter-for-jfilechooser-dialog
 */
public class FileExtensionFilter extends FileFilter{
	
	private String extension; //acceptable extension
	private String description; //description
	
	/**
	 * Filters files in files chooser dialogs by specified extension.
	 * @param extension Specified extension
	 */
	public FileExtensionFilter(String extension)
	{
		this.extension = extension; //set extension
		
		//set description of the extension
		if (extension.equals(".pdf"))
		{
			this.description = "PDF Documents (*.pdf)";
		}
		else if (extension.equals(".csv"))
		{
			this.description = "Comma-seperated values Documents (*.csv)";
		}
		else if (extension.equals(".txt"))
		{
			this.description = "Textfiles (*.txt)";
		}
		else
		{
			this.description = "";
		}
	}

	/**
	 * Checks whether file chosen is acceptable
	 * @param f Specified file to check if acceptable based on its extension
	 * @return whether file f is acceptable based on its extension
	 */
	public boolean accept(File f) {
		if (f.isDirectory()) 
		{
			return true; //allow directories
		}
		return f.getName().endsWith(extension); //checks if file name ends with csv
	}

	/**
	 * Provide description to show in file chooser dialog.
	 */
	public String getDescription() {
		return description;
	}
}
