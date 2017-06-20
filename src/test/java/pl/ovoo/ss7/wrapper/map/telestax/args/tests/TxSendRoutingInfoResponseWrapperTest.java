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
import org.mobicents.protocols.ss7.map.api.service.callhandling.RoutingInfo;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.telestax.TxIMSIAddressWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxRoutingInfoWrapper;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxSendRoutingInfoResponseWrapper;

public class TxSendRoutingInfoResponseWrapperTest extends WrapperBaseTest {

    TxSendRoutingInfoResponseWrapper txSendRoutingInfoResponseWrapper;

    @Before
    public void setUp() throws Exception {
        txSendRoutingInfoResponseWrapper = new TxSendRoutingInfoResponseWrapper();
        IMSI imsi = mapParameterFactory.createIMSI("260345678897567");
        TxIMSIAddressWrapper txIMSIAddressWrapper = new TxIMSIAddressWrapper(imsi);
        txSendRoutingInfoResponseWrapper.setImsi(txIMSIAddressWrapper);
        ISDNAddressString addressString = mapParameterFactory.createISDNAddressString(
                AddressNature.international_number, NumberingPlan.land_mobile, "0048678987345");
        RoutingInfo routingInfo = mapParameterFactory.createRoutingInfo(addressString);
        TxRoutingInfoWrapper txRoutingInfoWrapper = new TxRoutingInfoWrapper(routingInfo);
        txSendRoutingInfoResponseWrapper.setRoutingInfo(txRoutingInfoWrapper);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {
        serializeToFile(txSendRoutingInfoResponseWrapper);
        TxSendRoutingInfoResponseWrapper tx = (TxSendRoutingInfoResponseWrapper) deserializeFromFile();

        assertTrue(txSendRoutingInfoResponseWrapper.getImsi().getAddress().equals(tx.getImsi().getAddress()));
        assertTrue(txSendRoutingInfoResponseWrapper.getTxImsi().getData().equals(tx.getTxImsi().getData()));
        assertTrue(txSendRoutingInfoResponseWrapper.getRoutingInfo().getNatureOfAddress().getValue() == tx
                .getRoutingInfo().getNatureOfAddress().getValue());
        assertTrue(txSendRoutingInfoResponseWrapper.getRoutingInfo().getNumberingPlan().getValue() == tx
                .getRoutingInfo().getNumberingPlan().getValue());
        assertTrue(txSendRoutingInfoResponseWrapper.getRoutingInfo().getRoamingNumber()
                .equals(tx.getRoutingInfo().getRoamingNumber()));
        assertTrue(txSendRoutingInfoResponseWrapper.getTxRoamingAddress().getRoamingNumber().getAddress()
                .equals(tx.getTxRoamingAddress().getRoamingNumber().getAddress()));

    }

}
