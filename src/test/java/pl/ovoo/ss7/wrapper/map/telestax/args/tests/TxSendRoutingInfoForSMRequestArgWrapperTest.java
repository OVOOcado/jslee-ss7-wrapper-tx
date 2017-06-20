package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMRequestArgWrapper;

public class TxSendRoutingInfoForSMRequestArgWrapperTest extends WrapperBaseTest {

    TxSendRoutingInfoForSMRequestArgWrapper txSendRoutingInfoForSMRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoForSMRequestArgWrapper = new TxSendRoutingInfoForSMRequestArgWrapper();
        ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.national_significant_number, NumberingPlan.land_mobile, "0048687983567");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapper = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoForSMRequestArgWrapper.setMsisdn(txISDNAddressStringWrapper);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoForSMRequestArgWrapper);
        TxSendRoutingInfoForSMRequestArgWrapper tx = (TxSendRoutingInfoForSMRequestArgWrapper) deserializeFromFile();

        assertTrue(
                txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getAddress().equals(tx.getMsisdn().getAddress()));
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getNature().getValue() == tx.getMsisdn()
                .getNature().getValue());
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getMsisdn().getNumberingPlan().getValue() == tx.getMsisdn()
                .getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoForSMRequestArgWrapper.getTxMsisdn().getAddress()
                .equals(tx.getTxMsisdn().getAddress()));
    }

}
