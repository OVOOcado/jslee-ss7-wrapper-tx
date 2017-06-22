/**
 * TxInvokeTimeoutEventWrapper.java
 *  
 * @author adam.skimina@ovoo.pl
 */
package pl.ovoo.ss7.wrapper.cap.telestax.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.slee.resource.cap.events.InvokeTimeout;

import pl.ovoo.ss7.wrapper.cap.event.InvokeTimeoutEventWrapper;

/**
 * TxInvokeTimeoutEventWrapper
 * 
 * @author adam.skimina@ovoo.pl
 */
public class TxInvokeTimeoutEventWrapper extends TxEventWrapper implements InvokeTimeoutEventWrapper {

    private final InvokeTimeout invokeTimeout;

    public TxInvokeTimeoutEventWrapper(final InvokeTimeout invokeTimeout, final ActivityContextInterface aci) {
        super(aci, invokeTimeout.getWrappedEvent());
        this.invokeTimeout = invokeTimeout;
    }

}
