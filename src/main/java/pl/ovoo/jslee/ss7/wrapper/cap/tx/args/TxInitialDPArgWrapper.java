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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.args;

import org.mobicents.protocols.ss7.cap.api.isup.CalledPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.CallingPartyNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.OriginalCalledNumberCap;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.primitive.BearerCapability;
import org.mobicents.protocols.ss7.inap.api.isup.CallingPartysCategoryInap;
import org.mobicents.protocols.ss7.inap.api.isup.HighLayerCompatibilityInap;
import org.mobicents.protocols.ss7.inap.api.isup.RedirectionInformationInap;

import pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapabilityWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartysCategoryWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM;
import pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper;



/**
 * TxInitialDPArgWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInitialDPArgWrapper implements InitialDPArgWrapper {

    /** The calling party number wrapper. */
    private transient CallingPartyNumberWrapper callingPartyNumberWrapper = null;
    
    /** The called party number wrapper. */
    private transient CalledPartyNumberWrapper calledPartyNumberWrapper = null;
    
    /** The redirecting party number wrapper. */
    private transient RedirectingPartyNumberWrapper redirectingPartyNumberWrapper = null;
    
    /** The bearer capability wrapper. */
    private transient BearerCapabilityWrapper bearerCapabilityWrapper = null;
    
    /** The high layer compatibility wrapper. */
    private transient HighLayerCompatibilityWrapper highLayerCompatibilityWrapper = null;
    
    /** The redirection information wrapper. */
    private transient RedirectionInformationWrapper redirectionInformationWrapper = null;
    
    /** The original called number wrapper. */
    private transient OriginalCalledNumberWrapper originalCalledNumberWrapper = null;
    
    /** The calling partys category wrapper. */
    private transient CallingPartysCategoryWrapper callingPartysCategoryWrapper = null;

    /** The calling party number. */
    private CallingPartyNumberCap callingPartyNumber;
    
    /** The called party number. */
    private CalledPartyNumberCap calledPartyNumber;
    
    /** The event type bcsm. */
    private org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM eventTypeBCSM;
    
    /** The redirecting party id. */
    private RedirectingPartyIDCap redirectingPartyID;
    
    /** The bearer capability. */
    private BearerCapability bearerCapability;
    
    /** The high layer compatibility. */
    private HighLayerCompatibilityInap highLayerCompatibility;
    
    /** The service key. */
    private int serviceKey;
    
    /** The redirection information inap. */
    private RedirectionInformationInap redirectionInformationInap;
    
    /** The original called party id. */
    private OriginalCalledNumberCap originalCalledPartyID;
    
    /** The calling partys category inap. */
    private CallingPartysCategoryInap callingPartysCategoryInap;

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasCallingPartyNumber()
     */
    @Override
    public boolean hasCallingPartyNumber() {
        return callingPartyNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getCallingPartyNumber()
     */
    @Override
    public CallingPartyNumberWrapper getCallingPartyNumber() {
        if (this.callingPartyNumberWrapper == null && callingPartyNumber != null) {
            this.callingPartyNumberWrapper = new TxCallingPartyNumberWrapper(callingPartyNumber);
        }
        return this.callingPartyNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setCallingPartyNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CallingPartyNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getEventTypeBCSM()
     */
    @Override
    public EventTypeBCSM getEventTypeBCSM() {
        if (eventTypeBCSM == null) {
            return null;
        }
        return EventTypeBCSM.valueOf(eventTypeBCSM.getCode());
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setEventTypeBCSM(pl.ovoo.jslee.ss7.wrapper.cap.args.EventTypeBCSM)
     */
    @Override
    public void setEventTypeBCSM(final EventTypeBCSM eventTypeBCSM) {
        if (eventTypeBCSM == null) {
            this.eventTypeBCSM = null;
        } else {
            this.eventTypeBCSM = org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM
                    .getInstance(eventTypeBCSM.getValue());
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasCalledPartyNumber()
     */
    @Override
    public boolean hasCalledPartyNumber() {
        return calledPartyNumber != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getCalledPartyNumber()
     */
    @Override
    public CalledPartyNumberWrapper getCalledPartyNumber() {
        if (this.calledPartyNumberWrapper == null && this.calledPartyNumber != null) {
            this.calledPartyNumberWrapper = new TxCalledPartyNumberWrapper(calledPartyNumber);
        }
        return this.calledPartyNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setCalledPartyNumber(pl.ovoo.jslee.ss7.wrapper.cap.args.CalledPartyNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasRedirectingPartyID()
     */
    @Override
    public boolean hasRedirectingPartyID() {
        return redirectingPartyID != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getRedirectingPartyID()
     */
    @Override
    public RedirectingPartyNumberWrapper getRedirectingPartyID() {
        if (this.redirectingPartyNumberWrapper == null && this.redirectingPartyID != null) {
            this.redirectingPartyNumberWrapper = new TxRedirectingPartyNumberWrapper(redirectingPartyID);
        }
        return this.redirectingPartyNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setRedirectingPartyID(pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasBearerCapability()
     */
    @Override
    public boolean hasBearerCapability() {
        return bearerCapability != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getBearerCapability()
     */
    @Override
    public BearerCapabilityWrapper getBearerCapability() {
        if (this.bearerCapabilityWrapper == null && this.bearerCapability != null) {
            this.bearerCapabilityWrapper = new TxBearerCapabilityWrapper(bearerCapability);
        }
        return this.bearerCapabilityWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setBearerCapability(pl.ovoo.jslee.ss7.wrapper.cap.args.BearerCapabilityWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasHighLayerCompatibility()
     */
    @Override
    public boolean hasHighLayerCompatibility() {
        return highLayerCompatibility != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getHighLayerCompatibility()
     */
    @Override
    public HighLayerCompatibilityWrapper getHighLayerCompatibility() {
        if (this.highLayerCompatibilityWrapper == null && this.highLayerCompatibility != null) {
            this.highLayerCompatibilityWrapper = new TxHighLayerCompatibilityWrapper(highLayerCompatibility);
        }
        return this.highLayerCompatibilityWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setHighLayerCompatibility(pl.ovoo.jslee.ss7.wrapper.cap.args.HighLayerCompatibilityWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getServiceKey()
     */
    @Override
    public int getServiceKey() {
        return serviceKey;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setServiceKey(int)
     */
    @Override
    public void setServiceKey(final int serviceKey) {
        this.serviceKey = serviceKey;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasRedirectionInformation()
     */
    @Override
    public boolean hasRedirectionInformation() {
        return redirectionInformationInap != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getRedirectionInformation()
     */
    @Override
    public RedirectionInformationWrapper getRedirectionInformation() {
        if (this.redirectionInformationWrapper == null && this.redirectionInformationInap != null) {
            this.redirectionInformationWrapper = new TxRedirectionInformationWrapper(redirectionInformationInap);
        }
        return this.redirectionInformationWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setRedirectionInformation(pl.ovoo.jslee.ss7.wrapper.cap.args.RedirectionInformationWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasOriginalCalledPartyID()
     */
    @Override
    public boolean hasOriginalCalledPartyID() {
        return originalCalledPartyID != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getOriginalCalledPartyID()
     */
    @Override
    public OriginalCalledNumberWrapper getOriginalCalledPartyID() {
        if (this.originalCalledNumberWrapper == null && this.originalCalledPartyID != null) {
            this.originalCalledNumberWrapper = new TxOriginalCalledNumberWrapper(originalCalledPartyID);
        }
        return this.originalCalledNumberWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#setOriginalCalledPartyID(pl.ovoo.jslee.ss7.wrapper.cap.args.OriginalCalledNumberWrapper)
     */
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

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#hasCallingPartysCategory()
     */
    @Override
    public boolean hasCallingPartysCategory() {
        return callingPartysCategoryInap != null;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper#getCallingPartysCategory()
     */
    @Override
    public CallingPartysCategoryWrapper getCallingPartysCategory() {
        if (this.callingPartysCategoryWrapper == null && callingPartysCategoryInap != null) {
            this.callingPartysCategoryWrapper = new TxCallingPartysCategoryWrapper(callingPartysCategoryInap);
        }
        return this.callingPartysCategoryWrapper;
    }

    /**
     * Gets the tx calling party number.
     *
     * @return the tx calling party number
     */
    public CallingPartyNumberCap getTxCallingPartyNumber() {
        return callingPartyNumber;
    }

    /**
     * Gets the tx called party number.
     *
     * @return the tx called party number
     */
    public CalledPartyNumberCap getTxCalledPartyNumber() {
        return calledPartyNumber;
    }

    /**
     * Gets the tx redirection information inap.
     *
     * @return the tx redirection information inap
     */
    public RedirectionInformationInap getTxRedirectionInformationInap() {
        return redirectionInformationInap;
    }

    /**
     * Gets the tx original called party id.
     *
     * @return the tx original called party id
     */
    public OriginalCalledNumberCap getTxOriginalCalledPartyID() {
        return originalCalledPartyID;
    }

    /**
     * Gets the tx calling partys category inap.
     *
     * @return the tx calling partys category inap
     */
    public CallingPartysCategoryInap getTxCallingPartysCategoryInap() {
        return callingPartysCategoryInap;
    }

    /**
     * Gets the tx high layer compatibility.
     *
     * @return the tx high layer compatibility
     */
    public HighLayerCompatibilityInap getTxHighLayerCompatibility() {
        return highLayerCompatibility;
    }

    /**
     * Gets the tx bearer capability.
     *
     * @return the tx bearer capability
     */
    public BearerCapability getTxBearerCapability() {
        return bearerCapability;
    }

    /**
     * Gets the tx event type bcsm.
     *
     * @return the tx event type bcsm
     */
    public org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM getTxEventTypeBCSM() {
        return eventTypeBCSM;
    }

    /**
     * Gets the tx redirecting party id.
     *
     * @return the tx redirecting party id
     */
    public RedirectingPartyIDCap getTxRedirectingPartyID() {
        return redirectingPartyID;
    }

    /**
     * Sets the tx calling party number.
     *
     * @param callingPartyNumber the new tx calling party number
     */
    public void setTxCallingPartyNumber(final CallingPartyNumberCap callingPartyNumber) {
        this.callingPartyNumber = callingPartyNumber;
        this.callingPartyNumberWrapper = null;
    }

    /**
     * Sets the tx called party number.
     *
     * @param calledPartyNumber the new tx called party number
     */
    public void setTxCalledPartyNumber(final CalledPartyNumberCap calledPartyNumber) {
        this.calledPartyNumber = calledPartyNumber;
        this.calledPartyNumberWrapper = null;
    }

    /**
     * Sets the tx redirection information inap.
     *
     * @param redirectionInformationInap the new tx redirection information inap
     */
    public void setTxRedirectionInformationInap(final RedirectionInformationInap redirectionInformationInap) {
        this.redirectionInformationInap = redirectionInformationInap;
        this.redirectionInformationWrapper = null;
    }

    /**
     * Sets the tx original called party id.
     *
     * @param originalCalledPartyID the new tx original called party id
     */
    public void setTxOriginalCalledPartyID(final OriginalCalledNumberCap originalCalledPartyID) {
        this.originalCalledPartyID = originalCalledPartyID;
        this.originalCalledNumberWrapper = null;
    }

    /**
     * Sets the tx calling partys category inap.
     *
     * @param callingPartysCategoryInap the new tx calling partys category inap
     */
    public void setTxCallingPartysCategoryInap(final CallingPartysCategoryInap callingPartysCategoryInap) {
        this.callingPartysCategoryInap = callingPartysCategoryInap;
        this.callingPartysCategoryWrapper = null;
    }

    /**
     * Sets the tx event type bcsm.
     *
     * @param eventTypeBCSM the new tx event type bcsm
     */
    public void setTxEventTypeBCSM(final org.mobicents.protocols.ss7.cap.api.primitives.EventTypeBCSM eventTypeBCSM) {
        this.eventTypeBCSM = eventTypeBCSM;
    }

    /**
     * Sets the tx redirecting party id.
     *
     * @param redirectingPartyID the new tx redirecting party id
     */
    public void setTxRedirectingPartyID(final RedirectingPartyIDCap redirectingPartyID) {
        this.redirectingPartyID = redirectingPartyID;
        this.redirectingPartyNumberWrapper = null;
    }

    /**
     * Sets the tx bearer capability.
     *
     * @param bearerCapability the new tx bearer capability
     */
    public void setTxBearerCapability(final BearerCapability bearerCapability) {
        this.bearerCapability = bearerCapability;
        this.bearerCapabilityWrapper = null;
    }

    /**
     * Sets the tx high layer compatibility.
     *
     * @param highLayerCompatibility the new tx high layer compatibility
     */
    public void setTxHighLayerCompatibility(final HighLayerCompatibilityInap highLayerCompatibility) {
        this.highLayerCompatibility = highLayerCompatibility;
        this.highLayerCompatibilityWrapper = null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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