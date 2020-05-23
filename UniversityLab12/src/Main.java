import com.company.db.DatabaseDao;
import com.company.db.DatabaseManufacturerDao;
import com.company.db.DatabaseSouvenirDao;
import com.company.entity.Manufacturer;
import com.company.entity.Souvenir;
import com.company.view.View;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();

        View view = new View();
        view.showInterface();

    }
}
