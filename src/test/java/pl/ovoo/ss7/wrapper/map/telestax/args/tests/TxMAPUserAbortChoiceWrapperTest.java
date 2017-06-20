package pl.ovoo.ss7.wrapper.map.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.inap.api.INAPException;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import org.mobicents.protocols.ss7.map.api.dialog.ProcedureCancellationReason;
import org.mobicents.protocols.ss7.map.api.dialog.ResourceUnavailableReason;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;
import pl.ovoo.ss7.wrapper.map.telestax.args.TxMAPUserAbortChoiceWrapper;

public class TxMAPUserAbortChoiceWrapperTest extends WrapperBaseTest {

    TxMAPUserAbortChoiceWrapper txMAPUserAbortChoiceWrapper;

    @Before
    public void setUp() throws Exception {

        MAPUserAbortChoice mapUserAbortChoice = mapParameterFactory.createMAPUserAbortChoice();
        mapUserAbortChoice.setProcedureCancellationReason(ProcedureCancellationReason.callRelease);
        mapUserAbortChoice.setResourceUnavailableReason(ResourceUnavailableReason.longTermResourceLimitation);
        mapUserAbortChoice.setUserResourceLimitation();
        mapUserAbortChoice.setUserSpecificReason();

        txMAPUserAbortChoiceWrapper = new TxMAPUserAbortChoiceWrapper(mapUserAbortChoice);
    }

    @Override
    public void testSerialization()
            throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException, INAPException, MAPException {

        serializeToFile(txMAPUserAbortChoiceWrapper);
        TxMAPUserAbortChoiceWrapper tx = (TxMAPUserAbortChoiceWrapper) deserializeFromFile();

        assertTrue(txMAPUserAbortChoiceWrapper.getTxMAPUserAbortChoice().getProcedureCancellationReason()
                .getCode() == tx.getTxMAPUserAbortChoice().getProcedureCancellationReason().getCode());
        assertTrue(txMAPUserAbortChoiceWrapper.getTxMAPUserAbortChoice().getResourceUnavailableReason().getCode() == tx
                .getTxMAPUserAbortChoice().getResourceUnavailableReason().getCode());

    }

}
