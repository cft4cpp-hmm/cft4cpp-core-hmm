package config;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import Khamd.Main;
import utils.SpecialCharacter;
import utils.Utils;

/**
 * Abstract class for storing setting
 *
 * @author ducanhnguyen
 */
public abstract class AbstractSetting implements ISettingv2 {
	public static String settingPath = Paths.CURRENT_PROJECT.LOCAL_FOLDER + File.separator + "setting.properties";

	// List of setting values
	public static Attributes attributes = new Attributes();

	public static String getAbsoluteSettingPath() {
		String path = "";
		try {
			path = new File(settingPath).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getFolderSettingPath() {
		String path = "";
		try {
			path = new File(settingPath).getParentFile().getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getValue(String key) {
		Attributes settings = loadSettings();
		for (String keyItem : settings.keySet())
			if (keyItem.equals(key)) {
				return settings.get(keyItem).replace("\n\r", "").replace("\r\n", "").replace("\n", "").replace("\r", "")
						.trim();
			}
		
		return "";
	}

	public static Attributes loadSettings() {
		Attributes settings = new Attributes();

		String content = Utils.readFileContent(getAbsoluteSettingPath());
		
		String[] data = content.split(SpecialCharacter.LINE_BREAK);
		for (String dataItem : data)
			if (dataItem.contains("=")) {
				String valueItem = "", keyItem = "";

				String[] element = dataItem.split("=");

				keyItem = element[0];
				if (keyItem.startsWith(COMMENT_PREFIX))
					// is comment. ignore
					continue;
				else if (element.length == 2) {
					if(keyItem.equals("GNU_MAKE_PATH")) {
						valueItem= Main.pathToMingw32;
					}
					else if(keyItem.equals("Z3_SOLVER_PATH")) {
						valueItem = Main.pathToZ3;
						
					}
					else if(keyItem.equals("SMT_LIB_FILE_PATH")) {
						valueItem = Paths.CURRENT_PROJECT.LOCAL_FOLDER + File.separator+Main.pathToConstraint;
					}
					else if(keyItem.equals("GNU_GCC_PATH")) {
						valueItem = Main.pathToGCC;
					}
					else if(keyItem.equals("GNU_GPlusPlus_PATH")) {
						valueItem = Main.pathToGPlus;
					}
					else if(keyItem.equals("TESTDATA_STRATEGY")){
						valueItem = "2";
					}
					else if(keyItem.equals("MCPP_EXE_PATH")) {
						valueItem = "..\\cft4cpp-core\\enviroment\\mcpp\\bin\\mcpp.exe";
					}
					else {
						valueItem = element[1];
						
					}
					settings.put(keyItem, valueItem);
				}
			}

		return settings;
	}

	public static void save(Attributes settings) {
		String output = "";
		for (String keyItem : settings.keySet())
			if (keyItem.startsWith(COMMENT_PREFIX))
				output += "\n" + keyItem + "\n";
			else
				output += keyItem + "=" + settings.get(keyItem) + "\n";

		Utils.writeContentToFile(output, settingPath);
	}

	public static void setValue(String key, Object value) {
		Attributes settings = loadSettings();
		settings.remove(key);
		settings.put(key, value + "");
		save(settings);
	}

	public static final void initialListProjectOpened() {
		RECENT_PROJECTS.clear();
		StringTokenizer token = new StringTokenizer(getValue(LIST_PROJECT_OPENED), ";");

		while (token.hasMoreTokens())
			RECENT_PROJECTS.add(token.nextToken());
	}

	public static Attributes getAttributes() {
		return attributes;
	}

	public static void setAttributes(Attributes attr) {
		attributes = attr;
	}
}
