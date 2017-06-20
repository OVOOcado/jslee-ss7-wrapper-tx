package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformation;
import org.mobicents.protocols.ss7.cap.primitives.DateAndTimeImpl;

import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationReportArgWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxRequestedInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallInformationReportArgWrapperTest extends WrapperBaseTest {

    TxCallInformationReportArgWrapper txCallInformationReportArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCallInformationReportArgWrapper = new TxCallInformationReportArgWrapper();
        Date date = new Date();

        DateAndTimeImpl dateAndTime = new DateAndTimeImpl(date.getYear(), date.getMonth(), date.getDay(),
                date.getHours(), date.getMinutes(), date.getSeconds());
        RequestedInformation requestedInformation = capFactory.createRequestedInformation_CallStopTime(dateAndTime);
        RequestedInformationWrapper[] requestedInformationWrapper = new RequestedInformationWrapper[1];
        requestedInformationWrapper[0] = new TxRequestedInformationWrapper(requestedInformation);
        txCallInformationReportArgWrapper.setRequestedInformationList(requestedInformationWrapper);

    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {

        serializeToFile(txCallInformationReportArgWrapper);
        TxCallInformationReportArgWrapper tx = (TxCallInformationReportArgWrapper) deserializeFromFile();

        assertTrue(txCallInformationReportArgWrapper.getTxRequestedInformation().get(0).getCallStopTimeValue()
                .getSecond() == tx.getTxRequestedInformation().get(0).getCallStopTimeValue().getSecond());
    }

}
