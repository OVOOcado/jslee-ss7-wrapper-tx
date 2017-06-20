package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.BasicServiceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCode;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberManagement.TeleserviceCodeValue;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SSForBSCode;
import org.mobicents.protocols.ss7.map.api.service.supplementary.SupplementaryCodeValue;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPSS_ForBS_CodeWrapper;

public class TxMAPSS_ForBS_CodeWrapperTest extends WrapperBaseTest {

    TxMAPSS_ForBS_CodeWrapper txMAPSS_ForBS_CodeWrapper;

    @Before
    public void setUp() throws Exception {

        TeleserviceCode teleserviceCode = mapParameterFactory
                .createTeleserviceCode(TeleserviceCodeValue.allPLMN_specificTS);
        BasicServiceCode basicServiceCode = mapParameterFactory.createBasicServiceCode(teleserviceCode);
        org.mobicents.protocols.ss7.map.api.service.supplementary.SSCode ssCode = mapParameterFactory
                .createSSCode(SupplementaryCodeValue.allCallOfferingSS);
        SSForBSCode ssForBSCode = mapParameterFactory.createSSForBSCode(ssCode, basicServiceCode, true);
        txMAPSS_ForBS_CodeWrapper = new TxMAPSS_ForBS_CodeWrapper(ssForBSCode);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPSS_ForBS_CodeWrapper);
        TxMAPSS_ForBS_CodeWrapper tx = (TxMAPSS_ForBS_CodeWrapper) deserializeFromFile();

        assertTrue(txMAPSS_ForBS_CodeWrapper.getTxSSForBSCode().getBasicService().getTeleservice()
                .getTeleserviceCodeValue().getCode() == tx.getTxSSForBSCode().getBasicService().getTeleservice()
                        .getTeleserviceCodeValue().getCode());
        assertTrue(txMAPSS_ForBS_CodeWrapper.getTxSSForBSCode().getSsCode().getSupplementaryCodeValue().getCode() == tx
                .getTxSSForBSCode().getSsCode().getSupplementaryCodeValue().getCode());
    }

}
