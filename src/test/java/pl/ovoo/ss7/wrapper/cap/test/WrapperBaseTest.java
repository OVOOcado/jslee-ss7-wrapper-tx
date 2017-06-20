package pl.ovoo.ss7.wrapper.cap.test;

import org.mobicents.protocols.ss7.cap.CAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.cap.api.CAPParameterFactory;
import org.mobicents.protocols.ss7.isup.ISUPParameterFactory;
import org.mobicents.protocols.ss7.isup.impl.message.parameter.ISUPParameterFactoryImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.INAPParameterFactory;
import org.mobicents.protocols.ss7.inap.isup.INAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.MAPParameterFactoryImpl;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.sccp.impl.parameter.ParameterFactoryImpl;
import org.mobicents.protocols.ss7.sccp.parameter.ParameterFactory;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;

public abstract class WrapperBaseTest {

    private final String serializeFilePath = "testFile.ser";

    public MAPParameterFactory mapParameterFactory;
    public ISUPParameterFactory isupFactory;
    public CAPParameterFactory capFactory;
    public INAPParameterFactory inapFactory;
    public ParameterFactory parameterFactory;

    public WrapperBaseTest() {

        mapParameterFactory = new MAPParameterFactoryImpl();
        inapFactory = new INAPParameterFactoryImpl();
        capFactory = new CAPParameterFactoryImpl();
        isupFactory = new ISUPParameterFactoryImpl();
        parameterFactory = new ParameterFactoryImpl();

    }

    public void serializeToFile(Object obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(serializeFilePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    public Object deserializeFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(serializeFilePath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object ob = in.readObject();
        in.close();
        fileIn.close();

        return ob;
    }

    @Test
    public abstract void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException;

}
