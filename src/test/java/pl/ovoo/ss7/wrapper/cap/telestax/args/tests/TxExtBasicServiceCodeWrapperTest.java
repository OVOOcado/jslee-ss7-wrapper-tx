package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxExtBasicServiceCodeWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxExtBasicServiceCodeWrapperTest extends WrapperBaseTest {

    TxExtBasicServiceCodeWrapper txExtBasicServiceCodeWrapper;

    @Before
    public void setUp() throws Exception {

        BearerServiceCode bearerServiceCode = mapParameterFactory
                .createBearerServiceCode(BearerServiceCodeValue.allBearerServices);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(bearerServiceCode.getBearerServiceCodeValue());
        ExtBasicServiceCode extBasicServiceCode = mapParameterFactory.createExtBasicServiceCode(extBearerServiceCode);
        txExtBasicServiceCodeWrapper = new TxExtBasicServiceCodeWrapper(extBasicServiceCode);

    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {

        serializeToFile(txExtBasicServiceCodeWrapper);
        TxExtBasicServiceCodeWrapper tx = (TxExtBasicServiceCodeWrapper) deserializeFromFile();

        assertTrue(txExtBasicServiceCodeWrapper.getExtBasicServiceCode().getExtBearerService()
                .getBearerServiceCodeValue() == tx.getExtBasicServiceCode().getExtBearerService()
                        .getBearerServiceCodeValue());

    }

}
