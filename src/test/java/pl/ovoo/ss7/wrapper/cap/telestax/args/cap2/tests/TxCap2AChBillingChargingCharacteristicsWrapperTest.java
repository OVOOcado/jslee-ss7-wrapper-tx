package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.tests;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.CAPExtensions;
import org.mobicents.protocols.ss7.cap.api.primitives.CriticalityType;
import org.mobicents.protocols.ss7.cap.api.primitives.ExtensionField;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.AudibleIndicator;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.CAMELAChBillingChargingCharacteristics;
import org.mobicents.protocols.ss7.inap.api.INAPException;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2AChBillingChargingCharacteristicsWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2AChBillingChargingCharacteristicsWrapperTest extends WrapperBaseTest {

    TxCap2AChBillingChargingCharacteristicsWrapper txCap2AChBillingChargingCharacteristicsWrapper;

    @Before
    public void setUp() throws Exception {

        final AudibleIndicator audibleIndicator = capFactory.createAudibleIndicator(new Boolean(true));

        final ExtensionField extensionField = capFactory.createExtensionField(1, CriticalityType.typeAbort,
                new byte[] { 64 });
        ArrayList<ExtensionField> extensionFields = new ArrayList<ExtensionField>(1);
        extensionFields.add(extensionField);
        final CAPExtensions capExtensions = capFactory.createCAPExtensions(extensionFields);
        CAMELAChBillingChargingCharacteristics cAMELAChBillingChargingCharacteristics = capFactory
                .createCAMELAChBillingChargingCharacteristics(20L, true, 30L, audibleIndicator, capExtensions, true);
        txCap2AChBillingChargingCharacteristicsWrapper = new TxCap2AChBillingChargingCharacteristicsWrapper(
                cAMELAChBillingChargingCharacteristics);

    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2AChBillingChargingCharacteristicsWrapper);
        TxCap2AChBillingChargingCharacteristicsWrapper tx = (TxCap2AChBillingChargingCharacteristicsWrapper) deserializeFromFile();

        assertTrue(txCap2AChBillingChargingCharacteristicsWrapper.getTimeDurationCharging()
                .getMaxCallPeriodDuration() == tx.getTimeDurationCharging().getMaxCallPeriodDuration());
        assertTrue(txCap2AChBillingChargingCharacteristicsWrapper.getTxAchBillingChargingCharacteristics()
                .getExtensions().getExtensionFields().get(0).getCriticalityType().getCode() == tx
                        .getTxAchBillingChargingCharacteristics().getExtensions().getExtensionFields().get(0)
                        .getCriticalityType().getCode());

    }

}
