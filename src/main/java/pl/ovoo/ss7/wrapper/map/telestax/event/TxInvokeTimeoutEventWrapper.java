/**
 * TxInvokeTimeoutEventWrapper.java
 *  
 * @author adam.skimina@ovoo.pl
 */
package pl.ovoo.ss7.wrapper.map.telestax.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.slee.resource.map.events.InvokeTimeout;

import pl.ovoo.ss7.wrapper.map.event.InvokeTimeoutEventWrapper;

/**
 * TxInvokeTimeoutEventWrapper
 * 
 * @author adam.skimina@ovoo.pl
 */
public class TxInvokeTimeoutEventWrapper extends TxMapEventWrapper implements InvokeTimeoutEventWrapper {

    private final InvokeTimeout invokeTimeout;

    public TxInvokeTimeoutEventWrapper(final InvokeTimeout invokeTimeout, ActivityContextInterface aci) {
        super(aci);
        this.invokeTimeout = invokeTimeout;
    }

    @Override
    public long getInvokeId() {
        return invokeTimeout.getWrappedEvent().getInvokeId();
    }

}
