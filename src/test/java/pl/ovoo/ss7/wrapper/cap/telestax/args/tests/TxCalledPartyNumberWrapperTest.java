package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.isup.message.parameter.CalledPartyNumber;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCalledPartyNumberWrapperTest extends WrapperBaseTest {

    TxCalledPartyNumberWrapper txCalledPartyNumberWrapper;

    @Before
    public void setUp() throws Exception {

        CalledPartyNumber calledPartyNumber = isupFactory.createCalledPartyNumber();
        calledPartyNumber.setNatureOfAddresIndicator(CalledPartyNumberWrapper.Nature.INTERNATIONAL.getValue());
        calledPartyNumber.setInternalNetworkNumberIndicator(
                CalledPartyNumberWrapper.RoutingToInternalNetworkNumber.ALLOWED.getValue());
        calledPartyNumber.setNumberingPlanIndicator(CalledPartyNumberWrapper.NumberingPlan.ISDN.getValue());
        calledPartyNumber.setAddress("0048123456789");
        CalledPartyNumberCap calledPartyNumberCap = capFactory.createCalledPartyNumberCap(calledPartyNumber);
        txCalledPartyNumberWrapper = new TxCalledPartyNumberWrapper(calledPartyNumberCap);
    }

    @Test
    public void testSerialization() throws ClassNotFoundException, IOException, CAPException {

        serializeToFile(txCalledPartyNumberWrapper);
        TxCalledPartyNumberWrapper tx = (TxCalledPartyNumberWrapper) deserializeFromFile();

        assertTrue(txCalledPartyNumberWrapper.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()
                .equals(tx.getTxCalledPartyNumber().getCalledPartyNumber().getAddress()));
        assertTrue(txCalledPartyNumberWrapper.getTxCalledPartyNumber().getCalledPartyNumber()
                .getInternalNetworkNumberIndicator() == tx.getTxCalledPartyNumber().getCalledPartyNumber()
                        .getInternalNetworkNumberIndicator());
    }

}
