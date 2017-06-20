package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.primitives.CalledPartyBCDNumber;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;

import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCalledPartyBCDNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCalledPartyBCDNumberWrapperTest extends WrapperBaseTest {

    TxCalledPartyBCDNumberWrapper txCalledPartyBCDNumberWrapper;

    @Before
    public void setUp() throws Exception {

        CalledPartyBCDNumber calledPartyBCDNumber = capFactory.createCalledPartyBCDNumber(
                AddressNature.international_number, NumberingPlan.land_mobile, "0048675923677");
        txCalledPartyBCDNumberWrapper = new TxCalledPartyBCDNumberWrapper(calledPartyBCDNumber);
    }

    @Test
    public void testSerialization() throws ClassNotFoundException, IOException {

        serializeToFile(txCalledPartyBCDNumberWrapper);
        TxCalledPartyBCDNumberWrapper tx = (TxCalledPartyBCDNumberWrapper) deserializeFromFile();

        assertTrue(txCalledPartyBCDNumberWrapper.getTxCalledPartyBCDNumber().getAddressNature().getIndicator() == tx
                .getTxCalledPartyBCDNumber().getAddressNature().getIndicator());
        assertTrue(txCalledPartyBCDNumberWrapper.getTxCalledPartyBCDNumber().getAddress()
                .equals(tx.getTxCalledPartyBCDNumber().getAddress()));

    }

}
