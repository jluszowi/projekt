package pl.edu.wszib.projekt.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.wszib.projekt.domains.SelectedColor;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SelectedColorDaoTest {

    public static final String COLOR1 = "red";
    public static final String COLOR2 = "blue";

    @Autowired
    SelectedColorDao selectedColorDao;

    @Before
    public void setUp() throws Exception {
        SelectedColor selectedColor1 = new SelectedColor("red", new Date());
        SelectedColor selectedColor2 = new SelectedColor("blue", new Date());

        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());

        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);

        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());

        System.out.println("--------------------------------");

    }

    //testujemy metodę do wyciągania danych
    @Test
    public void testFetchAllData() {

        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();
        int counter = 0;
        for (SelectedColor selectedColor : selectedColors) {
            counter++;
        }
    assertTrue(counter >= 2);
    }

    @Test
    public void testFindByColor() {

        List<SelectedColor> selectedColors = selectedColorDao.findByColor("red");
        System.out.println("-------------------");
        assertEquals("red", selectedColors.get(0).getColor());


    }


}