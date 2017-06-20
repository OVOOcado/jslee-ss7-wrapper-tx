package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.BearerCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxBearerCapabilityWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxBearerCapabilityWrapperTest extends WrapperBaseTest {

    TxBearerCapabilityWrapper txBearerCapabilityWrapper;

    @Before
    public void setUp() throws Exception {

        UserServiceInformation userServiceInformation = isupFactory.createUserServiceInformation();
        userServiceInformation.setAssignor(UserServiceInformation._ASS_ASSIGNOR_ONLY);
        userServiceInformation.setInformationTransferCapability(10);

        BearerCap bearerCap = capFactory.createBearerCap(userServiceInformation);
        BearerCapability bearerCapability = capFactory.createBearerCapability(bearerCap);

        txBearerCapabilityWrapper = new TxBearerCapabilityWrapper(bearerCapability);
    }

    @Test
    public void testSerialization() throws ClassNotFoundException, IOException, CAPException, Ss7WrapperException {

        serializeToFile(txBearerCapabilityWrapper);
        TxBearerCapabilityWrapper tx = (TxBearerCapabilityWrapper) deserializeFromFile();

        assertTrue(txBearerCapabilityWrapper.getTxBearerCapability().getBearerCap().getUserServiceInformation()
                .getInformationTransferCapability() == tx.getTxBearerCapability().getBearerCap()
                        .getUserServiceInformation().getInformationTransferCapability());

    }

}
