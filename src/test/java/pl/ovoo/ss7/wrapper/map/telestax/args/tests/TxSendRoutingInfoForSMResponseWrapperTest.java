package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoForSMResponseWrapper;

public class TxSendRoutingInfoForSMResponseWrapperTest extends WrapperBaseTest {
    TxSendRoutingInfoForSMResponseWrapper txSendRoutingInfoForSMResponseWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoForSMResponseWrapper = new TxSendRoutingInfoForSMResponseWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260345678456789");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txSendRoutingInfoForSMResponseWrapper.setImsi(txIMSIAddressWrapper);
        ISDNAddressString isdnAddressString = mapParameterFactory.createISDNAddressString(
                AddressNature.network_specific_number, NumberingPlan.land_mobile, "0048678675987");
        TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = new TxISDNAddressStringWrapperImpl(
                isdnAddressString);
        txSendRoutingInfoForSMResponseWrapper.setMscAddress(txISDNAddressStringWrapperImpl);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txSendRoutingInfoForSMResponseWrapper);
        TxSendRoutingInfoForSMResponseWrapper tx = (TxSendRoutingInfoForSMResponseWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoForSMResponseWrapper.getIMSI().getAddress().equals(tx.getIMSI().getAddress()));
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getMscAddress().getNumberingPlan().getValue() == tx
                .getMscAddress().getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getTxImsi().getData().equals(tx.getTxImsi().getData()));
        assertTrue(txSendRoutingInfoForSMResponseWrapper.getTxMscAddress().getAddressNature().getIndicator() == tx
                .getTxMscAddress().getAddressNature().getIndicator());
    }

}
