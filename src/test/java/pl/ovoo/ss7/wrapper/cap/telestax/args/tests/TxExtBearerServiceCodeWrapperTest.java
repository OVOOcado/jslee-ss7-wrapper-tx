package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxExtBearerServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxExtBearerServiceCodeWrapperTest extends WrapperBaseTest {

    TxExtBearerServiceCodeWrapper txExtBearerServiceCodeWrapper;

    @Before
    public void setUp() throws Exception {

        BearerServiceCode bearerServiceCode = mapParameterFactory
                .createBearerServiceCode(BearerServiceCodeValue.allSpeechFollowedByDataCDA);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(bearerServiceCode.getBearerServiceCodeValue());
        txExtBearerServiceCodeWrapper = new TxExtBearerServiceCodeWrapper(extBearerServiceCode);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txExtBearerServiceCodeWrapper);
        TxExtBearerServiceCodeWrapper tx = (TxExtBearerServiceCodeWrapper) deserializeFromFile();

        assertTrue(txExtBearerServiceCodeWrapper.getData()[0] == tx.getData()[0]);
    }

}
