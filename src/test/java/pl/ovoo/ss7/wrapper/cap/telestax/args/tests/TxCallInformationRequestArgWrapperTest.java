package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import pl.ovoo.ss7.wrapper.cap.args.RequestedInformationType;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxCallInformationRequestArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxCallInformationRequestArgWrapperTest extends WrapperBaseTest {

    TxCallInformationRequestArgWrapper txCallInformationRequestArgWrapper;

    @Before
    public void setUp() throws Exception {

        txCallInformationRequestArgWrapper = new TxCallInformationRequestArgWrapper();

        RequestedInformationType requestedInformationType = RequestedInformationType.valueOf(
                org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.RequestedInformationType.callConnectedElapsedTime
                        .getCode());
        RequestedInformationType[] requestedInformationTypes = new RequestedInformationType[1];
        requestedInformationTypes[0] = requestedInformationType;
        txCallInformationRequestArgWrapper.setRequestedInformationTypeList(requestedInformationTypes);

    }

    @Test
    public void testSerialization() throws ClassNotFoundException, IOException {

        serializeToFile(txCallInformationRequestArgWrapper);
        TxCallInformationRequestArgWrapper tx = (TxCallInformationRequestArgWrapper) deserializeFromFile();

        assertTrue(txCallInformationRequestArgWrapper.getTxRequestedInformationTypes().get(0).getCode() == tx
                .getTxRequestedInformationTypes().get(0).getCode());
    }

}
