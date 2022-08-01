package softuni.exam.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    <T> T fromFile(String filepath, Class<T> tClass) throws JAXBException, FileNotFoundException;
    <T> void writeToFail(String filepath, T entity) throws JAXBException;
}
