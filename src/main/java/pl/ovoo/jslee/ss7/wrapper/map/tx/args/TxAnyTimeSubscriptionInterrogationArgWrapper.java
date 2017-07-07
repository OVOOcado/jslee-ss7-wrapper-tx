/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx.args;

import org.mobicents.protocols.ss7.map.api.primitives.ISDNAddressString;
import org.mobicents.protocols.ss7.map.api.primitives.SubscriberIdentity;
import org.mobicents.protocols.ss7.map.api.service.mobility.subscriberInformation.RequestedSubscriptionInfo;
import pl.ovoo.jslee.ss7.wrapper.common.args.AddressStringWrapper;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxISDNAddressStringWrapperImpl;
import pl.ovoo.jslee.ss7.wrapper.map.args.AnyTimeSubscriptionInterrogationArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPRequestedSubscriptionInfoWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MAPSubscriberIdentityWrapper;

/**
 * TxAnyTimeSubscriptionInterrogationArgWrapper
 *
 * @author kacper.mosienski@ovoo.pl
 */
public class TxAnyTimeSubscriptionInterrogationArgWrapper implements AnyTimeSubscriptionInterrogationArgWrapper {

    private transient MAPSubscriberIdentityWrapper subscriberIdentityWrapper = null;
    private transient MAPRequestedSubscriptionInfoWrapper requestedSubscriptionInfoWrapper = null;
    private transient AddressStringWrapper gsmScfAddressWrapper = null;

    private SubscriberIdentity subscriberIdentity;
    private RequestedSubscriptionInfo requestedSubscriptionInfo;
    private ISDNAddressString gsmScfAddress;

    @Override
    public void setSubscriberIdentity(MAPSubscriberIdentityWrapper mAPSubscriberIdentityWrapper) {
        if (mAPSubscriberIdentityWrapper == null) {
            this.subscriberIdentity = null;
            this.subscriberIdentityWrapper = null;
        } else {
            final TxMAPSubscriberIdentityWrapper txMAPSubscriberIdentityWrapper = (TxMAPSubscriberIdentityWrapper) mAPSubscriberIdentityWrapper;
            this.subscriberIdentity = txMAPSubscriberIdentityWrapper.getTxMAPSubscriberIdentity();
            this.subscriberIdentityWrapper = txMAPSubscriberIdentityWrapper;
        }
    }

    public MAPSubscriberIdentityWrapper getSubscriberIdentityWrapper() {
        if (this.subscriberIdentityWrapper == null && this.subscriberIdentity != null) {
            this.subscriberIdentityWrapper = new TxMAPSubscriberIdentityWrapper(subscriberIdentity);
        }
        return this.subscriberIdentityWrapper;
    }

    @Override
    public void setRequestedSubscriptionInfo(MAPRequestedSubscriptionInfoWrapper mAPRequestedSubscriptionInfoWrapper) {
        if (mAPRequestedSubscriptionInfoWrapper == null) {
            this.requestedSubscriptionInfo = null;
            this.requestedSubscriptionInfoWrapper = null;
        } else {
            final TxMAPRequestedSubscriptionInfoWrapper txMAPRequestedSubscriptionInfoWrapper = (TxMAPRequestedSubscriptionInfoWrapper) mAPRequestedSubscriptionInfoWrapper;
            this.requestedSubscriptionInfo = txMAPRequestedSubscriptionInfoWrapper.getTxRequestedSubscriptionInfo();
            this.requestedSubscriptionInfoWrapper = txMAPRequestedSubscriptionInfoWrapper;
        }
    }

    public MAPRequestedSubscriptionInfoWrapper getRequestedSubscriptionInfoWrapper() {
        if (this.requestedSubscriptionInfoWrapper == null && this.requestedSubscriptionInfo != null) {
            this.requestedSubscriptionInfoWrapper = new TxMAPRequestedSubscriptionInfoWrapper(
                    requestedSubscriptionInfo);
        }
        return this.requestedSubscriptionInfoWrapper;
    }

    @Override
    public void setGsmSCF_Address(AddressStringWrapper gsmSCF_Address) {
        if (gsmSCF_Address == null) {
            this.gsmScfAddress = null;
            this.gsmScfAddressWrapper = null;
        } else {
            final TxISDNAddressStringWrapperImpl txISDNAddressStringWrapperImpl = (TxISDNAddressStringWrapperImpl) gsmSCF_Address;
            gsmScfAddress = txISDNAddressStringWrapperImpl.getTxAddress();
            this.gsmScfAddressWrapper = txISDNAddressStringWrapperImpl;
        }
    }

    public AddressStringWrapper getGsmScfAddressWrapper() {
        if (this.gsmScfAddressWrapper == null && this.gsmScfAddress != null) {
            this.gsmScfAddressWrapper = new TxISDNAddressStringWrapperImpl(gsmScfAddress);
        }
        return this.gsmScfAddressWrapper;
    }

    public SubscriberIdentity getTxSubscriberIdentity() {
        return subscriberIdentity;
    }

    public RequestedSubscriptionInfo getTxRequestedSubscriptionInfo() {
        return requestedSubscriptionInfo;
    }

    public ISDNAddressString getTxGsmScfAddress() {
        return gsmScfAddress;
    }

    @Override
    public String toString() {
        return "TxAnyTimeSubscriptionInterrogationArgWrapper [subscriberIdentity=" + subscriberIdentity
                + ", requestedSubscriptionInfo=" + requestedSubscriptionInfo + ", gsmScfAddress=" + gsmScfAddress + "]";
    }

}
