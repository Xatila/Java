package xmlexercise.config;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParserImpl implements XmlParser {
    private JAXBContext jaxbcontext;


    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T fromFile(String filepath, Class<T> tClass) throws JAXBException, FileNotFoundException {
        this.jaxbcontext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        return (T) unmarshaller.unmarshal(new FileReader(filepath));
    }

    @Override
    public <T> void writeToFail(String filepath, T entity) throws JAXBException {
        this.jaxbcontext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = jaxbcontext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new File(filepath));
    }
}
