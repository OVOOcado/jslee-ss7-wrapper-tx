package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxConnectSMSArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.common.args.ISDNAddressStringWrapper;
import pl.ovoo.ss7.wrapper.common.telestax.TxISDNAddressStringWrapperImpl;

public class TxConnectSMSArgWrapperTest extends WrapperBaseTest {

    TxConnectSMSArgWrapper txConnectSMSArgWrapper;

    @Before
    public void setUp() throws Exception {

        CalledPartyBCDNumber calledPartyBCDNumber = capFactory
                .createCalledPartyBCDNumber(AddressNature.international_number, NumberingPlan.ISDN, "0048237236123");
        ISDNAddressString isdnAddressString = mapParameterFactory
                .createISDNAddressString(AddressNature.international_number, NumberingPlan.data, "s");

        txConnectSMSArgWrapper = new TxConnectSMSArgWrapper(calledPartyBCDNumber, isdnAddressString);

        CalledPartyBCDNumberWrapper calledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(
                calledPartyBCDNumber);
        ISDNAddressStringWrapper isdnaAddressStringWrapper = new TxISDNAddressStringWrapperImpl(isdnAddressString);
        txConnectSMSArgWrapper.setDestinationSubscriberNumber(calledPartyBCDNumberWrapper);
        txConnectSMSArgWrapper.setSMSCAddress(isdnaAddressStringWrapper);
    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {
        serializeToFile(txConnectSMSArgWrapper);
        TxConnectSMSArgWrapper tx = (TxConnectSMSArgWrapper) deserializeFromFile();

        assertTrue(txConnectSMSArgWrapper.getTxDestinationSubscriberNumber().getAddressNature().getIndicator() == tx
                .getTxDestinationSubscriberNumber().getAddressNature().getIndicator());
        assertTrue(txConnectSMSArgWrapper.getTxSmscAddress().getAddressNature() == tx.getTxSmscAddress()
                .getAddressNature());
        assertTrue(txConnectSMSArgWrapper.getTxSmscAddress().getNumberingPlan() == tx.getTxSmscAddress()
                .getNumberingPlan());

    }

}
