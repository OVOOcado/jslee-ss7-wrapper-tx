package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.primitives.SendingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.cap.telestax.args.TxAChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxApplyChargingArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxSendingSideIDWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxApplyChargingArgWrapperTest extends WrapperBaseTest {

    TxApplyChargingArgWrapper txApplyChargingArgWrapper;

    @Before
    public void setUp() throws Exception {

        txApplyChargingArgWrapper = new TxApplyChargingArgWrapper();

        CAMELAChBillingChargingCharacteristics cAMELAChBillingChargingCharacteristics = capFactory
                .createCAMELAChBillingChargingCharacteristics(new byte[] { 8 });
        TxAChBillingChargingCharacteristicsWrapper txAChBillingChargingCharacteristicsWrapper = new TxAChBillingChargingCharacteristicsWrapper(
                cAMELAChBillingChargingCharacteristics);
        txApplyChargingArgWrapper.setAChBillingChargingCharacteristics(txAChBillingChargingCharacteristicsWrapper);

        LegType legType = LegType.leg1;
        SendingSideID sendingSideID = capFactory.createSendingSideID(legType);
        TxSendingSideIDWrapper txSendingSideIDWrapper = new TxSendingSideIDWrapper(sendingSideID);
        txApplyChargingArgWrapper.setPartyToCharge(txSendingSideIDWrapper);
    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        serializeToFile(txApplyChargingArgWrapper);
        TxApplyChargingArgWrapper tx = (TxApplyChargingArgWrapper) deserializeFromFile();

        assertTrue(txApplyChargingArgWrapper.getTxAchBillingChargingCharacteristics().getData()[0] == tx
                .getTxAchBillingChargingCharacteristics().getData()[0]);
        assertTrue(txApplyChargingArgWrapper.getTxPartyToCharge().getSendingSideID().getCode() == tx
                .getTxPartyToCharge().getSendingSideID().getCode());
    }

}
