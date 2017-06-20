package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedSubscriptionInfo;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.args.MAPRequestedSubscriptionInfoWrapper;
import pl.ovoo.ss7.wrapper.map.args.MAPSS_ForBS_CodeWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPRequestedSubscriptionInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMapArgsFactory;

public class TxMAPRequestedSubscriptionInfoWrapperTest extends WrapperBaseTest {

    TxMAPRequestedSubscriptionInfoWrapper txMAPRequestedSubscriptionInfoWrapper;

    @Before
    public void setUp() throws Exception {

        /*
         * TxMapArgsFactory txMapArgsFactory = new
         * TxMapArgsFactory(mapParameterFactory);
         * 
         * MAPSS_ForBS_CodeWrapper mapSS_ForBS_CodeWrapper = txMapArgsFactory
         * .createMAPSS_ForBS_CodeWrapper(pl.ovoo.ss7.wrapper.map.args.SSCode.
         * CFB); MAPRequestedSubscriptionInfoWrapper
         * mapRequestedSubscriptionInfoWrapper = txMapArgsFactory
         * .createMAPRequestedSubscriptionInfoWrapper(mapSS_ForBS_CodeWrapper);
         * TxMAPRequestedSubscriptionInfoWrapper
         * txMAPRequestedSubscriptionInfoWrapper =
         * (TxMAPRequestedSubscriptionInfoWrapper)
         * mapRequestedSubscriptionInfoWrapper; RequestedSubscriptionInfo
         * requestedSubscriptionInfo = txMAPRequestedSubscriptionInfoWrapper
         * .getTxRequestedSubscriptionInfo();
         * txMAPRequestedSubscriptionInfoWrapper = new
         * TxMAPRequestedSubscriptionInfoWrapper(requestedSubscriptionInfo);
         */
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPRequestedSubscriptionInfoWrapper);
        TxMAPRequestedSubscriptionInfoWrapper tx = (TxMAPRequestedSubscriptionInfoWrapper) deserializeFromFile();

        // assertTrue(txMAPRequestedSubscriptionInfoWrapper.getTxRequestedSubscriptionInfo());

    }

}
