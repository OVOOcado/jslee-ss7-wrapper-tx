package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtTeleserviceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCodeValue;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxExtTeleserviceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxExtTeleserviceCodeWrapperTest extends WrapperBaseTest {

    TxExtTeleserviceCodeWrapper txExtTeleserviceCodeWrapper;

    @Before
    public void setUp() throws Exception {

        ExtTeleserviceCode extTeleserviceCode = mapParameterFactory
                .createExtTeleserviceCode(TeleserviceCodeValue.allVoiceGroupCallServices);
        txExtTeleserviceCodeWrapper = new TxExtTeleserviceCodeWrapper(extTeleserviceCode);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txExtTeleserviceCodeWrapper);
        TxExtTeleserviceCodeWrapper tx = (TxExtTeleserviceCodeWrapper) deserializeFromFile();

        assertTrue(tx.getData()[0] == txExtTeleserviceCodeWrapper.getData()[0]);

    }

}
