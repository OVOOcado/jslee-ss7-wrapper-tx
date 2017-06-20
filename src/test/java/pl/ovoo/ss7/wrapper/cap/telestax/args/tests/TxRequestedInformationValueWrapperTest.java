package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.CauseCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.CauseIndicators;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRequestedInformationValueWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxRequestedInformationValueWrapperTest extends WrapperBaseTest {

    TxRequestedInformationValueWrapper txRequestedInformationValueWrapper;

    @Before
    public void setUp() throws Exception {

        final CauseIndicators causeIndicators = isupFactory.createCauseIndicators();
        causeIndicators.setCauseValue(CauseIndicators._CV_ALL_CLEAR);
        causeIndicators.setCodingStandard(CauseIndicators._CODING_STANDARD_IOS_IEC);
        causeIndicators.setDiagnostics(new byte[] { 64, 32, 16 });
        causeIndicators.setLocation(CauseIndicators._LOCATION_PRIVATE_NSLU);
        causeIndicators.setRecommendation(CauseIndicators._PARAMETER_CODE);
        final CauseCap causeCap = capFactory.createCauseCap(causeIndicators);
        final RequestedInformation requestedInformation_ReleaseCause = capFactory
                .createRequestedInformation_ReleaseCause(causeCap);
        txRequestedInformationValueWrapper = new TxRequestedInformationValueWrapper(requestedInformation_ReleaseCause);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txRequestedInformationValueWrapper);
        TxRequestedInformationValueWrapper tx = (TxRequestedInformationValueWrapper) deserializeFromFile();

        assertTrue(txRequestedInformationValueWrapper.getTxRequestedInformationValue().getReleaseCauseValue()
                .getCauseIndicators().getCauseValue() == tx.getTxRequestedInformationValue().getReleaseCauseValue()
                        .getCauseIndicators().getCauseValue());
        assertTrue(txRequestedInformationValueWrapper.getTxRequestedInformationValue().getReleaseCauseValue()
                .getCauseIndicators().getLocation() == tx.getTxRequestedInformationValue().getReleaseCauseValue()
                        .getCauseIndicators().getLocation());

    }

}
