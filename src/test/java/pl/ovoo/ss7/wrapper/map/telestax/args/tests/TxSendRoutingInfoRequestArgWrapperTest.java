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
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoRequestArgWrapper;

public class TxSendRoutingInfoRequestArgWrapperTest extends WrapperBaseTest {

    TxSendRoutingInfoRequestArgWrapper txSendRoutingInfoRequestArgWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoRequestArgWrapper = new TxSendRoutingInfoRequestArgWrapper();
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.network_specific_number, NumberingPlan.ISDN, "0048678987345");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoRequestArgWrapper.setMsisdn(txISDNAddressStringWrapperImpl);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoRequestArgWrapper);
        TxSendRoutingInfoRequestArgWrapper tx = (TxSendRoutingInfoRequestArgWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getAddress().equals(tx.getMsisdn().getAddress()));
        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getNature().getValue() == tx.getMsisdn().getNature()
                .getValue());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getMsisdn().getNumberingPlan().getValue() == tx.getMsisdn()
                .getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getTxMsisdn().getAddressNature().getIndicator() == tx
                .getTxMsisdn().getAddressNature().getIndicator());
        assertTrue(txSendRoutingInfoRequestArgWrapper.getTxMsisdn().getAddress().equals(tx.getTxMsisdn().getAddress()));

    }

}
