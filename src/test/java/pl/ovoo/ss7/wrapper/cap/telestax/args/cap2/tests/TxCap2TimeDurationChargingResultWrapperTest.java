package pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.primitives.AChChargingAddress;
import org.mobicents.protocols.ss7.cap.api.primitives.CAPExtensions;
import org.mobicents.protocols.ss7.cap.api.primitives.CriticalityType;
import org.mobicents.protocols.ss7.cap.api.primitives.ExtensionField;
import org.mobicents.protocols.ss7.cap.api.primitives.ReceivingSideID;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeDurationChargingResult;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.TimeInformation;
import org.mobicents.protocols.ss7.cap.service.circuitSwitchedCall.primitive.TimeInformationImpl;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.inap.api.primitives.LegID;
import org.mobicents.protocols.ss7.inap.api.primitives.LegType;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.cap2.TxCap2TimeDurationChargingResultWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCap2TimeDurationChargingResultWrapperTest extends WrapperBaseTest {

    TxCap2TimeDurationChargingResultWrapper txCap2TimeDurationChargingResultWrapper;

    @Before
    public void setUp() throws Exception {

        final ReceivingSideID receivingSideID = capFactory.createReceivingSideID(LegType.leg1);
        final TimeInformation timeInformation = capFactory
                .createTimeInformation(TimeInformationImpl._ID_timeIfNoTariffSwitch);
        final ExtensionField extensionField = capFactory.createExtensionField(2, CriticalityType.typeIgnore,
                new byte[] { 64 });
        ArrayList<ExtensionField> extensionFields = new ArrayList<ExtensionField>(1);
        extensionFields.add(extensionField);
        final CAPExtensions capExtensions = capFactory.createCAPExtensions(extensionFields);
        final LegID legID = inapFactory.createLegID(true, LegType.leg2);
        final AChChargingAddress achChargingAddress = capFactory.createAChChargingAddress(legID);
        final TimeDurationChargingResult timeDurationChargingResult = capFactory.createTimeDurationChargingResult(
                receivingSideID, timeInformation, true, true, capExtensions, achChargingAddress);

        txCap2TimeDurationChargingResultWrapper = new TxCap2TimeDurationChargingResultWrapper(
                timeDurationChargingResult);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txCap2TimeDurationChargingResultWrapper);
        TxCap2TimeDurationChargingResultWrapper tx = (TxCap2TimeDurationChargingResultWrapper) deserializeFromFile();

        assertTrue(txCap2TimeDurationChargingResultWrapper.getTxTimeDurationChargingResult().getAChChargingAddress()
                .getLegID().getSendingSideID().getCode() == tx.getTxTimeDurationChargingResult().getAChChargingAddress()
                        .getLegID().getSendingSideID().getCode());

    }

}
