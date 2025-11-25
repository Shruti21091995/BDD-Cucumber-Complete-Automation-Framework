package Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class ConfigReaderUtils 
{
	 Properties proper;
	WebDriver driver;
public ConfigReaderUtils(String URL) throws IOException
 {
	 proper=new Properties();
	 FileInputStream fis=new FileInputStream(URL);
	 proper.load(fis);
}

 public String getValue(String key)
 {
	 return proper.getProperty(key);
 }
 
}
