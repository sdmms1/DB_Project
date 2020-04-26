package train.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.TrainApplication;
import train.model.City;
import train.model.Station;

import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainApplication.class)
@AutoConfigureMockMvc
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @Test
    public void myCityMapperTest() {

//        City city = cityMapper.queryByCode(330100);
        City city = cityMapper.queryByName("杭州市");

        System.out.println(city);
        Iterator iterator = city.getStations().iterator();
        int i = 1;
        while (iterator.hasNext()) {
            Station station = (Station) iterator.next();
            System.out.println(i + " : " + station);
            i++;
        }

        List<City> cities = cityMapper.queryByProvince("浙江省");
        for (City c : cities) {
            System.out.println(c.getCity_name() + " station.size() = " + c.getStations().size());
        }

    }


}