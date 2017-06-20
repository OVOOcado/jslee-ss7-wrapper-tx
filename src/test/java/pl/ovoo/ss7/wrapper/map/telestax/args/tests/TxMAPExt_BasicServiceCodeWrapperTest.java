package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BearerServiceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.ExtBearerServiceCode;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPExt_BasicServiceCodeWrapper;

public class TxMAPExt_BasicServiceCodeWrapperTest extends WrapperBaseTest {

    TxMAPExt_BasicServiceCodeWrapper txMAPExt_BasicServiceCodeWrapper;

    @Before
    public void setUp() throws Exception {

        BearerServiceCode bearerServiceCode = mapParameterFactory
                .createBearerServiceCode(BearerServiceCodeValue.allAlternateSpeech_DataCDS);
        ExtBearerServiceCode extBearerServiceCode = mapParameterFactory
                .createExtBearerServiceCode(bearerServiceCode.getBearerServiceCodeValue());
        ExtBasicServiceCode extBasicServiceCode = mapParameterFactory.createExtBasicServiceCode(extBearerServiceCode);

        txMAPExt_BasicServiceCodeWrapper = new TxMAPExt_BasicServiceCodeWrapper(extBasicServiceCode);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txMAPExt_BasicServiceCodeWrapper);
        TxMAPExt_BasicServiceCodeWrapper tx = (TxMAPExt_BasicServiceCodeWrapper) deserializeFromFile();

        assertTrue(txMAPExt_BasicServiceCodeWrapper.getTxMAPExt_BasicServiceCode().getExtBearerService()
                .getBearerServiceCodeValue().getCode() == tx.getTxMAPExt_BasicServiceCode().getExtBearerService()
                        .getBearerServiceCodeValue().getCode());
    }

}
