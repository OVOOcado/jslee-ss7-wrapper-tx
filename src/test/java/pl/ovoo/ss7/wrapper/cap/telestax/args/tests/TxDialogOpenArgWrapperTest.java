package pl.ovoo.ss7.wrapper.cap.telestax.args.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.mobicents.protocols.ss7.cap.CAPDialogImpl;
import org.mobicents.protocols.ss7.cap.CAPProviderImpl;
import org.mobicents.protocols.ss7.cap.api.CAPApplicationContext;
import org.mobicents.protocols.ss7.cap.api.CAPDialog;
import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.CAPProvider;
import org.mobicents.protocols.ss7.cap.api.dialog.CAPDialogState;
import org.mobicents.protocols.ss7.tcap.api.TCAPProvider;

import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.CapDialogWrapper;
import pl.ovoo.ss7.wrapper.cap.args.ArgsFactory;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxDialogOpenArgWrapper;
import pl.ovoo.ss7.wrapper.cap.test.WrapperBaseTest;

public class TxDialogOpenArgWrapperTest extends WrapperBaseTest {

    TxDialogOpenArgWrapper txDialogOpenArgWrapper;

    @Before
    public void setUp() throws Exception {
        // TCAPProvider
        // CAPProvider capProvider = new CAPProviderImpl( "name", );
        // final CAPDialog capDialog = capProvider.getCAPDialog(1L);
        // txDialogOpenArgWrapper = new TxDialogOpenArgWrapper(capDialog);

    }

    @Override
    public void testSerialization() throws IOException, ClassNotFoundException, CAPException, Ss7WrapperException {
        // assertTrue();

    }

}
