package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;

import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxAChBillingChargingCharacteristicsWrapperTest extends WrapperBaseTest {

    TxAChBillingChargingCharacteristicsWrapper txAChBillingChargingCharacteristicsWrapper;

    @Before
    public void setUp() throws Exception {

        CAMELAChBillingChargingCharacteristics cAMELAChBillingChargingCharacteristics = capFactory
                .createCAMELAChBillingChargingCharacteristics(new byte[] { 16 });
        txAChBillingChargingCharacteristicsWrapper = new TxAChBillingChargingCharacteristicsWrapper(
                cAMELAChBillingChargingCharacteristics);
    }

    @Test
    @Override
    public void testSerialization() throws IOException, ClassNotFoundException {

        serializeToFile(txAChBillingChargingCharacteristicsWrapper);
        TxAChBillingChargingCharacteristicsWrapper tx = (TxAChBillingChargingCharacteristicsWrapper) deserializeFromFile();

        assertTrue(txAChBillingChargingCharacteristicsWrapper.getTxAchBillingChargingCharacteristics()
                .getData()[0] == tx.getTxAchBillingChargingCharacteristics().getData()[0]);
    }

}
