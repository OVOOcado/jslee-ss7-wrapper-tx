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

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;

import pl.ovoo.ss7.wrapper.cap.args.BearerCapabilityWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.CallingPartysCategoryWrapper;
import pl.ovoo.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;
import pl.ovoo.ss7.wrapper.cap.args.InitialDPArgWrapper;
import pl.ovoo.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.ss7.wrapper.cap.args.RedirectionInformationWrapper;


/**
 * TxInitialDPArgWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInitialDPArgWrapper implements InitialDPArgWrapper {

    private transient CallingPartyNumberWrapper callingPartyNumberWrapper = null;
    private transient CalledPartyNumberWrapper calledPartyNumberWrapper = null;
    private transient RedirectingPartyNumberWrapper redirectingPartyNumberWrapper = null;
    private transient BearerCapabilityWrapper bearerCapabilityWrapper = null;
    private transient HighLayerCompatibilityWrapper highLayerCompatibilityWrapper = null;
    private transient RedirectionInformationWrapper redirectionInformationWrapper = null;
    private transient OriginalCalledNumberWrapper originalCalledNumberWrapper = null;
    private transient CallingPartysCategoryWrapper callingPartysCategoryWrapper = null;

    private CallingPartyNumberCap callingPartyNumber;
    private CalledPartyNumberCap calledPartyNumber;
    private org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM eventTypeBCSM;
    private RedirectingPartyIDCap redirectingPartyID;
    private BearerCapability bearerCapability;
    private HighLayerCompatibilityInap highLayerCompatibility;
    private int serviceKey;
    private RedirectionInformationInap redirectionInformationInap;
    private OriginalCalledNumberCap originalCalledPartyID;
    private CallingPartysCategoryInap callingPartysCategoryInap;

    @Override
    public boolean hasCallingPartyNumber() {
        return callingPartyNumber != null;
    }

    @Override
    public CallingPartyNumberWrapper getCallingPartyNumber() {
        if (this.callingPartyNumberWrapper == null && callingPartyNumber != null) {
            this.callingPartyNumberWrapper = new TxCallingPartyNumberWrapper(callingPartyNumber);
        }
        return this.callingPartyNumberWrapper;
    }

    @Override
    public void setCallingPartyNumber(final CallingPartyNumberWrapper callingPartyNumber) {
        if (callingPartyNumber == null) {
            this.callingPartyNumber = null;
            this.callingPartyNumberWrapper = null;
        } else {
            final TxCallingPartyNumberWrapper txCallingPartyNumberWrapper = (TxCallingPartyNumberWrapper) callingPartyNumber;
            this.callingPartyNumber = txCallingPartyNumberWrapper.getTxCallingPartyNumber();
            this.callingPartyNumberWrapper = txCallingPartyNumberWrapper;
        }
    }

    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (eventTypeBCSM == null) {
            return null;
        }
        return EventTypeBCSM.valueOf(eventTypeBCSM.getCode());
    }

    @Override
    public void setEventTypeBCSM(final EventTypeBCSM eventTypeBCSM) {
        if (eventTypeBCSM == null) {
            this.eventTypeBCSM = null;
        } else {
            this.eventTypeBCSM = org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM
                    .getInstance(eventTypeBCSM.getValue());
        }
    }

    @Override
    public boolean hasCalledPartyNumber() {
        return calledPartyNumber != null;
    }

    @Override
    public CalledPartyNumberWrapper getCalledPartyNumber() {
        if (this.calledPartyNumberWrapper == null && this.calledPartyNumber != null) {
            this.calledPartyNumberWrapper = new TxCalledPartyNumberWrapper(calledPartyNumber);
        }
        return this.calledPartyNumberWrapper;
    }

    @Override
    public void setCalledPartyNumber(final CalledPartyNumberWrapper calledPartyNumber) {
        if (calledPartyNumber == null) {
            this.calledPartyNumber = null;
            this.calledPartyNumberWrapper = null;
        } else {
            final TxCalledPartyNumberWrapper txCalledPartyNumberWrapper = (TxCalledPartyNumberWrapper) calledPartyNumber;
            this.calledPartyNumber = txCalledPartyNumberWrapper.getTxCalledPartyNumber();
            this.calledPartyNumberWrapper = txCalledPartyNumberWrapper;
        }
    }

    @Override
    public boolean hasRedirectingPartyID() {
        return redirectingPartyID != null;
    }

    @Override
    public RedirectingPartyNumberWrapper getRedirectingPartyID() {
        if (this.redirectingPartyNumberWrapper == null && this.redirectingPartyID != null) {
            this.redirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(redirectingPartyID);
        }
        return this.redirectingPartyNumberWrapper;
    }

    @Override
    public void setRedirectingPartyID(final RedirectingPartyNumberWrapper redirectingPartyID) {
        if (redirectingPartyID == null) {
            this.redirectingPartyID = null;
            this.redirectingPartyNumberWrapper = null;
        } else {
            final TxRedirectingPartyNumberWrapper txRedirectingPartyNumberWrapper = (TxRedirectingPartyNumberWrapper) redirectingPartyID;
            this.redirectingPartyID = txRedirectingPartyNumberWrapper.getTxRedirectingPartyNumber();
            this.redirectingPartyNumberWrapper = txRedirectingPartyNumberWrapper;
        }
    }

    @Override
    public boolean hasBearerCapability() {
        return bearerCapability != null;
    }

    @Override
    public BearerCapabilityWrapper getBearerCapability() {
        if (this.bearerCapabilityWrapper == null && this.bearerCapability != null) {
            this.bearerCapabilityWrapper = new TxBearerCapabilityWrapper(bearerCapability);
        }
        return this.bearerCapabilityWrapper;
    }

    @Override
    public void setBearerCapability(final BearerCapabilityWrapper bearerCapability) {
        if (bearerCapability == null) {
            this.bearerCapability = null;
            this.bearerCapabilityWrapper = null;
        } else {
            final TxBearerCapabilityWrapper txBearerCapabilityWrapper = (TxBearerCapabilityWrapper) bearerCapability;
            this.bearerCapability = txBearerCapabilityWrapper.getTxBearerCapability();
            this.bearerCapabilityWrapper = txBearerCapabilityWrapper;
        }
    }

    @Override
    public boolean hasHighLayerCompatibility() {
        return highLayerCompatibility != null;
    }

    @Override
    public HighLayerCompatibilityWrapper getHighLayerCompatibility() {
        if (this.highLayerCompatibilityWrapper == null && this.highLayerCompatibility != null) {
            this.highLayerCompatibilityWrapper = new TxHighLayerCompatibilityWrapper(highLayerCompatibility);
        }
        return this.highLayerCompatibilityWrapper;
    }

    @Override
    public void setHighLayerCompatibility(final HighLayerCompatibilityWrapper highLayerCompatibility) {
        if (highLayerCompatibility == null) {
            this.highLayerCompatibility = null;
            this.highLayerCompatibilityWrapper = null;
        } else {
            final TxHighLayerCompatibilityWrapper txHighLayerCompatibilityWrapper = (TxHighLayerCompatibilityWrapper) highLayerCompatibility;
            this.highLayerCompatibility = txHighLayerCompatibilityWrapper.getTxHighLayerCompatibilityInap();
            this.highLayerCompatibilityWrapper = txHighLayerCompatibilityWrapper;
        }
    }

    @Override
    public int getServiceKey() {
        return serviceKey;
    }

    @Override
    public void setServiceKey(final int serviceKey) {
        this.serviceKey = serviceKey;
    }

    @Override
    public boolean hasRedirectionInformation() {
        return redirectionInformationInap != null;
    }

    @Override
    public RedirectionInformationWrapper getRedirectionInformation() {
        if (this.redirectionInformationWrapper == null && this.redirectionInformationInap != null) {
            this.redirectionInformationWrapper = new TxRedirectionInformationWrapper(redirectionInformationInap);
        }
        return this.redirectionInformationWrapper;
    }

    @Override
    public void setRedirectionInformation(final RedirectionInformationWrapper redirectionInformation) {
        if (redirectionInformation == null) {
            this.redirectionInformationInap = null;
            this.redirectionInformationWrapper = null;
        } else {
            final TxRedirectionInformationWrapper txRedirectionInformationWrapper = (TxRedirectionInformationWrapper) redirectionInformation;
            this.redirectionInformationInap = txRedirectionInformationWrapper.getTxRedirectionInformation();
            this.redirectionInformationWrapper = txRedirectionInformationWrapper;
        }
    }

    @Override
    public boolean hasOriginalCalledPartyID() {
        return originalCalledPartyID != null;
    }

    @Override
    public OriginalCalledNumberWrapper getOriginalCalledPartyID() {
        if (this.originalCalledNumberWrapper == null && this.originalCalledPartyID != null) {
            this.originalCalledNumberWrapper = new TxOriginalCalledNumberWrapper(originalCalledPartyID);
        }
        return this.originalCalledNumberWrapper;
    }

    @Override
    public void setOriginalCalledPartyID(final OriginalCalledNumberWrapper originalCalledPartyID) {
        if (originalCalledPartyID == null) {
            this.originalCalledPartyID = null;
            this.originalCalledNumberWrapper = null;
        } else {
            final TxOriginalCalledNumberWrapper txOriginalCalledNumberWrapper = (TxOriginalCalledNumberWrapper) originalCalledPartyID;
            this.originalCalledPartyID = txOriginalCalledNumberWrapper.getTxOriginalCalledNumber();
            this.originalCalledNumberWrapper = txOriginalCalledNumberWrapper;
        }
    }

    @Override
    public boolean hasCallingPartysCategory() {
        return callingPartysCategoryInap != null;
    }

    @Override
    public CallingPartysCategoryWrapper getCallingPartysCategory() {
        if (this.callingPartysCategoryWrapper == null && callingPartysCategoryInap != null) {
            this.callingPartysCategoryWrapper = new TxCallingPartysCategoryWrapper(callingPartysCategoryInap);
        }
        return this.callingPartysCategoryWrapper;
    }

    public CallingPartyNumberCap getTxCallingPartyNumber() {
        return callingPartyNumber;
    }

    public CalledPartyNumberCap getTxCalledPartyNumber() {
        return calledPartyNumber;
    }

    public RedirectionInformationInap getTxRedirectionInformationInap() {
        return redirectionInformationInap;
    }

    public OriginalCalledNumberCap getTxOriginalCalledPartyID() {
        return originalCalledPartyID;
    }

    public CallingPartysCategoryInap getTxCallingPartysCategoryInap() {
        return callingPartysCategoryInap;
    }

    public HighLayerCompatibilityInap getTxHighLayerCompatibility() {
        return highLayerCompatibility;
    }

    public BearerCapability getTxBearerCapability() {
        return bearerCapability;
    }

    public org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM getTxEventTypeBCSM() {
        return eventTypeBCSM;
    }

    public RedirectingPartyIDCap getTxRedirectingPartyID() {
        return redirectingPartyID;
    }

    public void setTxCallingPartyNumber(final CallingPartyNumberCap callingPartyNumber) {
        this.callingPartyNumber = callingPartyNumber;
        this.callingPartyNumberWrapper = null;
    }

    public void setTxCalledPartyNumber(final CalledPartyNumberCap calledPartyNumber) {
        this.calledPartyNumber = calledPartyNumber;
        this.calledPartyNumberWrapper = null;
    }

    public void setTxRedirectionInformationInap(final RedirectionInformationInap redirectionInformationInap) {
        this.redirectionInformationInap = redirectionInformationInap;
        this.redirectionInformationWrapper = null;
    }

    public void setTxOriginalCalledPartyID(final OriginalCalledNumberCap originalCalledPartyID) {
        this.originalCalledPartyID = originalCalledPartyID;
        this.originalCalledNumberWrapper = null;
    }

    public void setTxCallingPartysCategoryInap(final CallingPartysCategoryInap callingPartysCategoryInap) {
        this.callingPartysCategoryInap = callingPartysCategoryInap;
        this.callingPartysCategoryWrapper = null;
    }

    public void setTxEventTypeBCSM(final org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM eventTypeBCSM) {
        this.eventTypeBCSM = eventTypeBCSM;
    }

    public void setTxRedirectingPartyID(final RedirectingPartyIDCap redirectingPartyID) {
        this.redirectingPartyID = redirectingPartyID;
        this.redirectingPartyNumberWrapper = null;
    }

    public void setTxBearerCapability(final BearerCapability bearerCapability) {
        this.bearerCapability = bearerCapability;
        this.bearerCapabilityWrapper = null;
    }

    public void setTxHighLayerCompatibility(final HighLayerCompatibilityInap highLayerCompatibility) {
        this.highLayerCompatibility = highLayerCompatibility;
        this.highLayerCompatibilityWrapper = null;
    }

    @Override
    public String toString() {
        return "TxInitialDPArgWrapper [callingPartyNumber=" + callingPartyNumber + ", calledPartyNumber="
                + calledPartyNumber + ", eventTypeBCSM=" + eventTypeBCSM + ", redirectingPartyID=" + redirectingPartyID
                + ", bearerCapability=" + bearerCapability + ", highLayerCompatibility=" + highLayerCompatibility
                + ", serviceKey=" + serviceKey + ", redirectionInformationInap=" + redirectionInformationInap
                + ", originalCalledPartyID=" + originalCalledPartyID + ", callingPartysCategoryInap="
                + callingPartysCategoryInap + "]";
    }
}