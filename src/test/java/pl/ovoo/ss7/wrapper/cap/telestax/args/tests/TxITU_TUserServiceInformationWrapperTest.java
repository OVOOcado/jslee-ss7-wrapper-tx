package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.isup.message.parameter.UserServiceInformation;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxITU_TUserServiceInformationWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxITU_TUserServiceInformationWrapperTest extends WrapperBaseTest {

    TxITU_TUserServiceInformationWrapper txITU_TUserServiceInformationWrapper;

    @Before
    public void setUp() throws Exception {

        UserServiceInformation userServiceInformation = isupFactory.createUserServiceInformation();
        userServiceInformation.setHDR(UserServiceInformation._HDR_INCLUDED);
        userServiceInformation.setCodingStandart(UserServiceInformation._CS_CCITT);
        userServiceInformation.setInformationTransferCapability(UserServiceInformation._ITR_1536);
        txITU_TUserServiceInformationWrapper = new TxITU_TUserServiceInformationWrapper(userServiceInformation);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException {

        serializeToFile(txITU_TUserServiceInformationWrapper);
        TxITU_TUserServiceInformationWrapper tx = (TxITU_TUserServiceInformationWrapper) deserializeFromFile();

        assertTrue(txITU_TUserServiceInformationWrapper.getTransferCapability().getValue() == tx.getTransferCapability()
                .getValue());
        assertTrue(txITU_TUserServiceInformationWrapper.getTxUserServiceInformation().getHDR() == tx
                .getTxUserServiceInformation().getHDR());

    }

}
