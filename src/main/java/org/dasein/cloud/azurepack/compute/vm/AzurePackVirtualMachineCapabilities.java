/**
 * Copyright (C) 2009-2015 Dell, Inc
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.azurepack.compute.vm;

import org.dasein.cloud.*;
import org.dasein.cloud.azurepack.AzurePackCloud;
import org.dasein.cloud.compute.*;
import org.dasein.cloud.util.NamingConstraints;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by vmunthiu on 3/4/2015.
 */
public class AzurePackVirtualMachineCapabilities extends AbstractCapabilities<AzurePackCloud> implements VirtualMachineCapabilities {
    public AzurePackVirtualMachineCapabilities(@Nonnull AzurePackCloud provider) {
        super(provider);
    }

    @Override
    public boolean canAlter(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canClone(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canPause(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canReboot(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canResume(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canStart(VmState fromState) throws CloudException, InternalException {
        return !fromState.equals(VmState.RUNNING);
    }

    @Override
    public boolean canStop(VmState fromState) throws CloudException, InternalException {
        return !VmState.STOPPED.equals(fromState) && !VmState.ERROR.equals(fromState) && !VmState.TERMINATED.equals(fromState);
    }

    @Override
    public boolean canSuspend(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean canTerminate(VmState fromState) throws CloudException, InternalException {
        return ( VmState.STOPPED.equals(fromState) || VmState.ERROR.equals(fromState) ) && !VmState.TERMINATED.equals(fromState);
    }

    @Override
    public boolean canUnpause(VmState fromState) throws CloudException, InternalException {
        return false;
    }

    @Override
    public int getMaximumVirtualMachineCount() throws CloudException, InternalException {
        return 0;
    }

    @Override
    public int getCostFactor(VmState state) throws CloudException, InternalException {
        return 0;
    }

    @Nonnull
    @Override
    public String getProviderTermForVirtualMachine(Locale locale) throws CloudException, InternalException {
        return "virtual machine";
    }

    @Nullable
    @Override
    public VMScalingCapabilities getVerticalScalingCapabilities() throws CloudException, InternalException {
        return null;
    }

    @Nonnull
    @Override
    public NamingConstraints getVirtualMachineNamingConstraints() throws CloudException, InternalException {
        return NamingConstraints.getStrictInstance(3, 15).constrainedBy(new char[]{'-', '.'});
    }

    @Nullable
    @Override
    public VisibleScope getVirtualMachineVisibleScope() {
        return VisibleScope.ACCOUNT_REGION;
    }

    @Nullable
    @Override
    public VisibleScope getVirtualMachineProductVisibleScope() {
        return VisibleScope.ACCOUNT_REGION;
    }

    @Nonnull
    @Override
    public String[] getVirtualMachineReservedUserNames() {
        return new String[0];
    }

    @Nonnull
    @Override
    public Requirement identifyDataCenterLaunchRequirement() throws CloudException, InternalException {
        return Requirement.REQUIRED;
    }

    @Nonnull
    @Override
    public Requirement identifyImageRequirement(@Nonnull ImageClass cls) throws CloudException, InternalException {
        return ( cls.equals(ImageClass.MACHINE) ? Requirement.REQUIRED : Requirement.NONE );
    }

    @Nonnull
    @Override
    public Requirement identifyUsernameRequirement() throws CloudException, InternalException {
        return Requirement.REQUIRED;
    }

    @Nonnull
    @Override
    public Requirement identifyPasswordRequirement(Platform platform) throws CloudException, InternalException {
        return Requirement.OPTIONAL;
    }

    @Nonnull
    @Override
    public Requirement identifyRootVolumeRequirement() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Nonnull
    @Override
    public Requirement identifyShellKeyRequirement(Platform platform) throws CloudException, InternalException {
        return Requirement.OPTIONAL;
    }

    @Nonnull
    @Override
    public Requirement identifyStaticIPRequirement() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Nonnull
    @Override
    public Requirement identifySubnetRequirement() throws CloudException, InternalException {
        return Requirement.NONE;
    }

    @Nonnull
    @Override
    public Requirement identifyVlanRequirement() throws CloudException, InternalException {
        return Requirement.OPTIONAL;
    }

    @Override
    public boolean isAPITerminationPreventable() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isBasicAnalyticsSupported() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isExtendedAnalyticsSupported() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isUserDataSupported() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isUserDefinedPrivateIPSupported() throws CloudException, InternalException {
        return false;
    }

    @Override
    public boolean isRootPasswordSSHKeyEncrypted() throws CloudException, InternalException {
        return false;
    }

    @Nonnull
    @Override
    public Iterable<Architecture> listSupportedArchitectures() throws InternalException, CloudException {
        return Collections.singletonList(Architecture.I64);
    }

    @Override
    public boolean supportsSpotVirtualMachines() throws InternalException, CloudException {
        return false;
    }

    @Override
    public boolean isVMProductDCConstrained() throws InternalException, CloudException{
        return false;
    }

    @Override
    public boolean supportsCloudStoredShellKey() throws InternalException, CloudException{
        return false;
    }

    @Override
    public boolean supportsClientRequestToken() throws InternalException, CloudException{
        return false;
    }

    @Override
    public boolean supportsAlterVM() {
        return false;
    }

    @Override
    public boolean supportsClone() {
        return false;
    }

    @Override
    public boolean supportsPause() {
        return false;
    }

    @Override
    public boolean supportsReboot() {
        return false;
    }

    @Override
    public boolean supportsResume() {
        return false;
    }

    @Override
    public boolean supportsStart() {
        return true;
    }

    @Override
    public boolean supportsStop() {
        return true;
    }

    @Override
    public boolean supportsSuspend() {
        return false;
    }

    @Override
    public boolean supportsTerminate() {
        return true;
    }

    @Override
    public boolean supportsUnPause() {
        return false;
    }
}
